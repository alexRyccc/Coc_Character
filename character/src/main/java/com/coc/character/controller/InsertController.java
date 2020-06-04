package com.coc.character.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.coc.character.Util.redis.RedisUtil;
import com.coc.character.ext.service.CreateCharacterServiceExt;
import com.coc.character.pojo.AddUser;
import com.coc.character.pojo.People;
import com.coc.character.pojo.Skill;
import com.coc.character.pojo.User;
import com.coc.character.pojo.req.PersonReq;
import org.apache.ibatis.reflection.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


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
    private static Logger logger = LoggerFactory.getLogger(InsertController.class);

    @Value("${username:ryc}")
    private String username;

    @Resource
    private RedisUtil redisUtil;
    @Cacheable(value = "User" ,key = "#id")
    @SentinelResource(value = "get", blockHandler = "exceptionHandler", blockHandlerClass = { ExceptionUtil.class })
    @RequestMapping("/username")
    public String get(String id) {
        Entry entry = null;
        try {
            entry = SphU.entry("username");
            logger.info("get user:{}",id);
            System.out.println(entry);
            return username;
        } catch (BlockException e1) {
            /* 流控逻辑处理 - 开始 */
            System.out.println("block!");
            /* 流控逻辑处理 - 结束 */
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
        return "finallys";
    }
    public String exceptionHandler(String id, BlockException e) {
        e.printStackTrace();
        return "错误发生在" + id;
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
