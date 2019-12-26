package com.coc.character.controller;

import com.coc.character.Util.CopyUtils;
import com.coc.character.ext.service.CreateCharacterServiceExt;
import com.coc.character.ext.serviceimpl.QueryCharacterExtImpl;
import com.coc.character.pojo.Person;
import com.coc.character.pojo.req.PersonReq;
import com.coc.character.pojo.resp.PersonResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ran_ych
 * @create 2019-12-25  9:29
 * @desc
 */
@RestController
@RequestMapping("/query")
public class queryController {
    @Resource(name = "QueryCharacterExtImpl")
    QueryCharacterExtImpl qry;

    private static Logger logger = LoggerFactory.getLogger(queryController.class);

    /**
     * 将创建的人物返回
     * @param personReq
     * @return
     */
    @PostMapping ("/person")
    private ResponseEntity<PersonResp> getPerson(@Validated @RequestBody PersonReq personReq){
       Person person = CopyUtils.convertObject(personReq,Person.class);
       //将person的值从数据库获取
       person = qry.selectByPrimaryKey(person);
       //将person转为传出的PersonResp
        PersonResp personResp =CopyUtils.convertObject(person,PersonResp.class);
        ResponseEntity<PersonResp>  resp =new ResponseEntity<PersonResp> (personResp, HttpStatus.OK);
    return  resp;
    }
}
