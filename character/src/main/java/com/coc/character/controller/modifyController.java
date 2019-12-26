package com.coc.character.controller;

import com.coc.character.Util.CopyUtils;
import com.coc.character.Util.redis.RedisUtil;
import com.coc.character.ext.serviceimpl.ModifyServiceImpl;
import com.coc.character.pojo.People;
import com.coc.character.pojo.Skill;
import com.coc.character.pojo.req.PersonReq;
import com.coc.character.pojo.req.SkillReq;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ran_ych
 * @create 2019-12-26  11:48
 * @desc
 */
@RestController
@RequestMapping("/modify")
public class modifyController {
    @Resource
    private RedisUtil redisUtil;

    @Resource(name = "ModifyServiceImpl")
    private ModifyServiceImpl modifyService;

    @PostMapping("/add")
    public ResponseEntity<?> createCharacter(@RequestBody SkillReq skill){
        int result =modifyService.updateByPrimaryKeySelective(skill);
        ResponseEntity<String> res =new ResponseEntity<>("技能修改成功", HttpStatus.NOT_FOUND);
        if (result==1){
             res =new ResponseEntity<>("技能修改失败", HttpStatus.OK);
        }
        return res;

    }

    @PostMapping("/updateredis")
    public  ResponseEntity<?> createCharacter(@RequestParam(value = "potential") String potential
    ,@RequestParam(value = "key") String key,@RequestParam(value = "value") String value){
        return null ;
    }
}
