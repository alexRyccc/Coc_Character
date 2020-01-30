package com.coc.character.controller;

import com.coc.character.Util.redis.RedisUtil;
import com.coc.character.ext.service.CreateCharacterServiceExt;
import com.coc.character.pojo.AddUser;
import com.coc.character.pojo.People;
import com.coc.character.pojo.Skill;
import com.coc.character.pojo.User;
import com.coc.character.pojo.req.PersonReq;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.logging.Logger;

/**
 * @author ran_ych
 * @create 2019-10-12  17:18
 * @desc
 */
@RestController
@RequestMapping("/user")
@RefreshScope
public class InsertController {
    @Resource(name = "createCharacterExt")
    CreateCharacterServiceExt createCharacterServiceExt;

    @Value("${username:ryc}")
    private String username;

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/username")
    public String get() {
        return username;
    }
    /**
     * 创建人物
     * @param addUser
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> createCharacter(@RequestBody PersonReq addUser){
        int age =Integer.parseInt(addUser.getAge());
        String name =addUser.getName();
        String sex =addUser.getSex();
        String userid =addUser.getUserid();
        String profession =addUser.getProfession();
        User users =createUsers(name,age,sex,userid);
        users.setBirthplace(addUser.getBirthplace());
        users.setNationality(addUser.getNationality());
        Skill skill =createSkill(profession);

        ResponseEntity<String> res;

        try {
            People user1 =createCharacterServiceExt.insertCharacter(users,skill);
            redisUtil.set("potential"+userid,user1.getPotential(),36000);
            redisUtil.set("interest"+userid,user1.getInterest(),36000);
            res= new ResponseEntity<>("人物创建成功", HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            res = new ResponseEntity<>("人物创建失败", HttpStatus.OK);
        }finally {


        }
        return res;

    }

    private User createUsers(String name,int age,String sex,String userid){
        User user =new User();
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);
        user.setUserid(userid);
        return user;
    }
    private Skill createSkill(String profession){
        Skill skill =new Skill();
        skill.setProfession(profession);
        return skill;
    }

}
