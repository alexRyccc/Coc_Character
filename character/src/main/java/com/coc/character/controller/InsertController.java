package com.coc.character.controller;

import com.coc.character.ext.service.CreateCharacterServiceExt;
import com.coc.character.pojo.AddUser;
import com.coc.character.pojo.People;
import com.coc.character.pojo.Skill;
import com.coc.character.pojo.User;
import org.slf4j.LoggerFactory;
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
public class InsertController {
    @Resource(name = "createCharacterExt")
    CreateCharacterServiceExt createCharacterServiceExt;

    //private final static Logger logger = (Logger) LoggerFactory.getLogger(InsertController .class);
    /*@GetMapping("/create/{name}/{age}/{sex}/{userid}/{profession}")
    public People createCharacter(@PathVariable("name")String name,@PathVariable("age")Integer age,@PathVariable("sex")String sex,
                                @PathVariable("userid")String userid,@PathVariable("profession")String profession){
        User users =createUsers(name,age,sex,userid);
        Skill skill =createSkill(profession);
        People user1 =createCharacterServiceExt.insertCharacter(users,skill);
        return user1;
    }*/

    @PostMapping("/create")
    public ResponseEntity<?> createCharacter(@RequestBody AddUser addUser){
        int age =Integer.parseInt(addUser.getAge());
        String name =addUser.getName();
        String sex =addUser.getSex();
        String userid =addUser.getUserid();
        String profession =addUser.getProfession();
        User users =createUsers(name,age,sex,userid);
        Skill skill =createSkill(profession);

        ResponseEntity<String> res;
        try {
            People user1 =createCharacterServiceExt.insertCharacter(users,skill);
            res= new ResponseEntity<>("人物创建成功", HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            res = new ResponseEntity<>("人物创建失败", HttpStatus.OK);
        }
        return res;

    }
    @GetMapping("hello")
    public String hello(){
        return "Hello world";
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
