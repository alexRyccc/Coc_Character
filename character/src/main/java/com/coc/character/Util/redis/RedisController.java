package com.coc.character.Util.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author ran_ych
 * @create 2019-10-18  17:50
 * @desc
 */
@RestController
public class RedisController {
    @Autowired
    RedisUtil redisUtil;

    @GetMapping("/hh/{name}/{age}")
    public String rediss(@PathVariable("name") String name,@PathVariable("age") String age){
        boolean flag;
        try {


         flag =redisUtil.setNx(name,age,10);
         if (!flag){
             return "error";
         }else{
             int shiwu = (int) redisUtil.getValue("shiwu");
             shiwu--;
             redisUtil.setValue("shiwu",shiwu);
         }
        }finally {
            redisUtil.delete(name);
        }
        return "十五买了";
    }
}
