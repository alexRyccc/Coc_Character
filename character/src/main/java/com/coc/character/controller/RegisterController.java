package com.coc.character.controller;

import com.coc.character.Util.CopyUtils;
import com.coc.character.Util.enums.SMSHelper;
import com.coc.character.ext.service.InsertPersonExt;
import com.coc.character.pojo.PhoneCheak;
import com.coc.character.pojo.UserPerson;
import com.coc.character.pojo.req.UserPersonReq;
import com.coc.character.ext.service.SmsServiceExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ran_ych
 * @create 2019-12-30  15:59
 * @desc
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Resource(name = "insertpersonextimpl")
    private InsertPersonExt insertPersonExt;

    @Resource(name ="smsserviceimpl")
    private SmsServiceExt smsServiceExt;

    private static Logger logger = LoggerFactory.getLogger(queryController.class);

    @PostMapping("/createnew")
    public ResponseEntity<?> createCharacter(@RequestBody UserPersonReq register){
        UserPerson user = CopyUtils.convertObject(register, UserPerson.class);
        int result =insertPersonExt.insertSelective(user);
        ResponseEntity<String> res=new ResponseEntity<String>("注册成功", HttpStatus.OK);

        if (result==-1){
            res=new ResponseEntity<String>("账号不符规范，请以字母开头,长度在6-12位", HttpStatus.OK);
        }else if(result ==-2){
            res=new ResponseEntity<String>("密码不合规矩，长度控制在6-12位之间", HttpStatus.OK);
        }else if(result ==-3){
            res=new ResponseEntity<String>("手机号有误", HttpStatus.OK);
        }

        return res;
    }

    /**
     * 短信下发注册
     */
    @PostMapping ("/phone")
    private ResponseEntity<?> getPhone(@RequestBody UserPersonReq register){

        PhoneCheak user = CopyUtils.convertObject(register, PhoneCheak.class);
        ResponseEntity<String> res=new ResponseEntity<String>("短信下发成功", HttpStatus.OK);
        //1、是注册信息
        if(!FinishSmsInformation(user)){

            return new ResponseEntity<String>("请输入正确的手机号", HttpStatus.OK);
        }

        String sms =smsServiceExt.sendMessage(user);


        if (sms.equals(SMSHelper.SMS_REDUNDANCE)){
            res=new ResponseEntity<String>("短信频次超频,一天只能发送三次", HttpStatus.OK);
        }else if(sms.equals(SMSHelper.SMS_INTERVAL_SHORT)){
            res=new ResponseEntity<String>("短信下发间隔过短", HttpStatus.OK);
        }else if(sms.equals(SMSHelper.SMS_FREE_TRUE)){
            res=new ResponseEntity<String>("免短信验证通过", HttpStatus.OK);
        }

        return res;
    }
    private boolean FinishSmsInformation(PhoneCheak p){
        if (!p.haveTruePhone()){
            return false;
        }
        //1、设置面短信检查
        p.setSmsfree(SMSHelper.NO_SMS_FREE);
        //2、设置为注册短信
        p.setStatus(SMSHelper.SMS_STATYS_REGISTER);
        //3、设置登录注册时间
        p.setSmsdt();
        p.setSmsdt();
        return true;
    }

    /**
     * 短信下发登录
     */
    @PostMapping ("/sign")
    private ResponseEntity<?> SignPerson (@RequestBody UserPersonReq register){
        UserPerson user = CopyUtils.convertObject(register, UserPerson.class);
        int result =insertPersonExt.insertSelective(user);
        ResponseEntity<String> res=new ResponseEntity<String>("注册成功", HttpStatus.OK);
        if (result==-1){
            res=new ResponseEntity<String>("账号不符规范，请以字母开头,长度在6-12位", HttpStatus.OK);
        }else if(result ==-2){
            res=new ResponseEntity<String>("密码不合规矩，长度控制在6-12位之间", HttpStatus.OK);
        }else if(result ==-3){
            res=new ResponseEntity<String>("手机号有误", HttpStatus.OK);
        }

        return res;
    }

}
