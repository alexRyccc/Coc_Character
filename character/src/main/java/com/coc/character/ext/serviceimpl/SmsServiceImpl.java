package com.coc.character.ext.serviceimpl;

import com.coc.character.Util.DateTimeUtils;
import com.coc.character.Util.enums.SMSHelper;
import com.coc.character.Util.redis.RedisUtil;
import com.coc.character.controller.queryController;
import com.coc.character.pojo.PhoneCheak;
import com.coc.character.ext.service.SmsServiceExt;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ran_ych
 * @create 2020-01-20  16:04
 * @desc
 */
@Service("smsserviceimpl")
public class SmsServiceImpl implements SmsServiceExt {
    private static Logger logger = LoggerFactory.getLogger(queryController.class);
    @Resource
    private RedisUtil redisUtil;
    /**
     * 短信下发功能
     *
     * @param userPerson
     */
    @Override
    public String sendMessage(PhoneCheak userPerson) {
        //1、免短信检查
        if (userPerson.getSmsfree().equals(SMSHelper.SMS_FREE)){
            return SMSHelper.SMS_FREE_TRUE;

        }
        //2、短信频次检查
        if (checkSendMessageFrequency(userPerson).equals(SMSHelper.SMS_REDUNDANCE)){
            return SMSHelper.SMS_REDUNDANCE;
        }else if(checkSendMessageFrequency(userPerson).equals(SMSHelper.SMS_INTERVAL_SHORT)){
            return SMSHelper.SMS_INTERVAL_SHORT;
        }
        //3、生产短信验证码
        createSmsCode(userPerson);
        return  SMSHelper.SMS_NORMAL;



    }

    private String checkSendMessageFrequency(PhoneCheak userPerson){
        //1、查询是登录短信还是注册短信
        //是注册短信
        if (userPerson.getStatus().equals(SMSHelper.SMS_STATYS_REGISTER)){
            //1、查询短信下总量
            String smsQuantity = (String) redisUtil.get(userPerson.getPhone()+ SMSHelper.REDIS_SMS_QUANTITY+ DateTimeUtils.getCurrentLocalDateTime());
            if (smsQuantity!=null){
                if( Integer.parseInt(smsQuantity)>3){
                    return SMSHelper.SMS_REDUNDANCE;
                }
                //2、查询短信下发间隔内次数
                String smsStatus = (String) redisUtil.get(userPerson.getPhone()+ SMSHelper.REDIS_SMS_STATUS);
                if (smsStatus!=null){
                    return SMSHelper.SMS_INTERVAL_SHORT;
                }
            }
            //是登录短信
        }else if(userPerson.getStatus().equals(SMSHelper.SMS_STATYS_SIGN)){
            //登录短信可以多次发送
            //1、查询短信下发间隔内次数
            String smsStatus = (String) redisUtil.get(userPerson.getPhone()+ SMSHelper.REDIS_SMS_STATUS_SIGN);
            if (smsStatus!=null){
                return SMSHelper.SMS_INTERVAL_SHORT;
            }
        }


     return SMSHelper.SMS_NORMAL;
    }
    public void createSmsCode(PhoneCheak userPerson){
        //1、生成短信验证码
        String smsCode  = String.valueOf(RandomStringUtils.randomNumeric(6));
        //2、记录短信流水，每一笔短信下发都需要记录
        redisUtil.incr(SMSHelper.SMS_NUMBER,1);
        String sms_number = (String) redisUtil.get(SMSHelper.SMS_NUMBER+ DateTimeUtils.getCurrentLocalDate());
        String smsNmber =DateTimeUtils.getCurrentLocalDateTime()+sms_number;
        userPerson.setSmsnumber(smsNmber);
        //

        //3、短信下发、用redis模拟、还要判断是登录还是注册
        if (userPerson.getStatus().equals(SMSHelper.SMS_STATYS_REGISTER)){
            redisUtil.set(userPerson.getPhone()+ SMSHelper.REDIS_SMS_STATUS,smsCode,120);
            redisUtil.incr(userPerson.getPhone()+ SMSHelper.REDIS_SMS_QUANTITY+ DateTimeUtils.getCurrentLocalDate(),1);
        }else if(userPerson.getStatus().equals(SMSHelper.SMS_STATYS_SIGN)){
            redisUtil.set(userPerson.getPhone()+ SMSHelper.REDIS_SMS_STATUS_SIGN,smsCode,60);

        }
        logger.info("平台短信下发");
    }
}
