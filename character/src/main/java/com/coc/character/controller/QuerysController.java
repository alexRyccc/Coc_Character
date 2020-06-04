package com.coc.character.controller;

import com.coc.character.Util.CopyUtils;
import com.coc.character.ext.service.InsertPersonExt;
import com.coc.character.ext.service.QueryCharacterExt;
import com.coc.character.pojo.Person;
import com.coc.character.pojo.req.PersonReq;
import com.coc.character.pojo.resp.PersonResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ran_ych
 * @create 2020-05-13  9:39
 * @desc
 */
@RestController
@RequestMapping("/query")
@RefreshScope
public class QuerysController {
    private static Logger logger = LoggerFactory.getLogger(QuerysController.class);

    @Resource(name = "insertpersonextimpl")
    public InsertPersonExt insertPersonExt;

    @Resource(name = "queryCharacterExtImpl")
    public QueryCharacterExt queryCharacterExt;


    @GetMapping("/app")
    public ResponseEntity<PersonResp> getPerson(@Validated int id){

        //将person的值从数据库获取
       Person person = insertPersonExt.select();
        //将person转为传出的PersonResp
        PersonResp personResp =CopyUtils.convertObject(person,PersonResp.class);
        ResponseEntity<PersonResp>  resp =new ResponseEntity<PersonResp> (personResp, HttpStatus.OK);
        return  resp;
    }

    @GetMapping("/getnumber/{id}")
    public int gerNumber(@PathVariable("id") Integer id){
        System.out.println(insertPersonExt.getNumber(id));
        return insertPersonExt.getNumber(id);
    }

    @GetMapping("/verifytoken")
    public String verifyToken(@Validated String token){
        return queryCharacterExt.verifyToken(token);
    }
}
