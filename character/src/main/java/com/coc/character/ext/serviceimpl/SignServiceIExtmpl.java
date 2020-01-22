package com.coc.character.ext.serviceimpl;

import com.coc.character.Util.CopyUtils;
import com.coc.character.Util.enums.SMSHelper;
import com.coc.character.controller.queryController;
import com.coc.character.ext.service.SignServiceExt;
import com.coc.character.ext.service.SmsServiceExt;
import com.coc.character.pojo.PhoneCheak;
import com.coc.character.pojo.UserPerson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ran_ych
 * @create 2020-01-22  20:45
 * @desc
 */
public class SignServiceIExtmpl implements SignServiceExt {
    private static Logger logger = LoggerFactory.getLogger(queryController.class);
    private SmsServiceExt smsServiceExt;
    /**
     * 用户登录
     *
     * @param userPerson
     */
    @Override
    public int SignPerson(UserPerson userPerson) {
        int  c =1;
        if ((c =checkMassger(userPerson))!=1){
            return  c;
        }
        PhoneCheak user = CopyUtils.convertObject(userPerson, PhoneCheak.class);
        //1、设置为登录短信
        FinishSmsInformation(user);
        smsServiceExt.sendMessage(user);
        return c;

        }

    private int checkMassger(UserPerson record) {
        int c = 1;
        if (!record.haveTruePassword()) {
            c = -2;
            return c;
        }
        if (!record.haveTrueUsername()) {
            c = -1;
            return c;
        }
        if (!record.haveTruePhone()) {
            c = -3;
            return c;
        }

        return c;
    }
    private boolean FinishSmsInformation(PhoneCheak p){
        if (!p.haveTruePhone()){
            return false;
        }
        //1、设置面短信检查
        p.setSmsfree(SMSHelper.NO_SMS_FREE);
        //2、设置为登录短信
        p.setStatus(SMSHelper.SMS_STATYS_SIGN);
        //3、设置登录注册时间
        p.setSmsdt();
        p.setSmsdt();
        return true;
    }
}
