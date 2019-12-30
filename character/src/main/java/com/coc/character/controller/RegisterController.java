package com.coc.character.controller;

import com.coc.character.Util.CopyUtils;
import com.coc.character.ext.service.InsertPersonExt;
import com.coc.character.pojo.UserPerson;
import com.coc.character.pojo.req.UserPersonReq;
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

}
