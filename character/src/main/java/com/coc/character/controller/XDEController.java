package com.coc.character.controller;

import com.coc.character.Util.CopyUtils;
import com.coc.character.Util.enums.SMSHelper;
import com.coc.character.ext.service.InsertPersonExt;
import com.coc.character.ext.service.SmsServiceExt;
import com.coc.character.pojo.*;
import com.coc.character.pojo.req.PersonReq;
import com.coc.character.pojo.req.UserPersonReq;
import com.coc.character.pojo.req.XdeReq;
import com.coc.character.pojo.resp.PersonResp;
import com.coc.character.pojo.resp.UserPersonResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * @author ran_ych
 * @create 2019-12-30  15:59
 * @desc
 */
@RestController
@RequestMapping("/xde")
public class XDEController {




    private static Logger logger = LoggerFactory.getLogger(XDEController.class);
    @PostMapping("/create")
    public ResponseEntity<?> createCharacter(@RequestBody XdeReq addUser){
        Random r = new Random();
        //姓名判断
        String name1 =addUser.getName1();
        String name2 =addUser.getName2();

        int ra =r.nextInt(99)+1;
        String jielun;
        if(ra>=90){
            jielun =name1+"和"+name2+"姻缘指数"+ra+"%,佳偶天成，琴瑟和谐，鸾凤和鸣";
        }else if(ra>=70&&ra<90){
            jielun =name1+"和"+name2+"姻缘指数"+ra+"%,百年修得同船渡，千年修得共枕眠";
        }else if(ra>=60&&ra<70){
            jielun =name1+"和"+name2+"姻缘指数"+ra+"%,床头打架床尾和，分分合合总相惜";
        }else{
            jielun =name1+"和"+name2+"姻缘指数"+ra+"%,可以学习一下新的婚姻法关于离婚的片段了";
        }
        addUser.setCgl(Integer.toString(ra));
        addUser.setJielun(jielun);
        ResponseEntity<XdeReq>  resp =new ResponseEntity<XdeReq> (addUser, HttpStatus.OK);
        return  resp;
    }
    }