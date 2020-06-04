package com.coc.character.ext.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coc.character.Util.String.StringUtil;
import com.coc.character.Util.enums.Verify;
import com.coc.character.Util.redis.RedisUtil;
import com.coc.character.controller.InsertController;
import com.coc.character.ext.service.QueryCharacterExt;
import com.coc.character.mapper.PersonMapper;
import com.coc.character.mapper.UserPersonDoMapper;
import com.coc.character.pojo.Person;
import com.coc.character.pojo.Userperson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author ran_ych
 * @create 2019-12-25  10:50
 * @desc
 */
@Service("queryCharacterExtImpl")
public class QueryCharacterExtImpl implements QueryCharacterExt {
    private static Logger logger = LoggerFactory.getLogger(InsertController.class);

    @Resource
    private PersonMapper personMapper;

    @Resource
    private UserPersonDoMapper userPersonDoMapper;

    @Resource
    private RedisUtil redisUtil;


    public Person selectByPrimaryKey(Person person) {
       return personMapper.getselectByPrimaryKey(person);
    }


    public Userperson selectUserPerson(Userperson userPerson) {
        //1、判断是否是手机号登录
        String phoneTrue =userPerson.getPhones();

        if(phoneTrue.equals("1")){
            //手机号登录
        }else{
            //正常登录

        }
        //2、判断是否保持登录
        String user = JSON.toJSONString(userPerson);
        String token = UUID.randomUUID().toString();
        logger.info("token：{}---user:{}",token,user);
        if (userPerson.getSave().equals("on")){
            redisUtil.set("REDIS_SESSION_KEY"+token, user,360000);
        }else{
            redisUtil.set("REDIS_SESSION_KEY"+token, user,360);
        }
        userPerson.setToken(token);

        return userPersonDoMapper.selectUserPerson(userPerson);
    }

    /**
     * 通过token查询是否在线
     *
     * @param token
     */


    public Userperson getByToken(String token) {
        if (StringUtil.isBlank(token)){
            return null;
        }else{
            String user = (String) redisUtil.get("REDIS_SESSION_KEY"+token);
            JSONObject jsonObject = JSON.parseObject(user);
            logger.info("json:{}---json.get:{}",jsonObject,jsonObject.get("username"));
        }

        return null;
    }

    /**
     * 验证Token是否存在
     *
     * @param token
     */
    @Override
    public String verifyToken(String token) {
        String o = (String) redisUtil.get(token);

        if (StringUtil.isBlank(o)){
            return Verify.IS_FALSE;
        }

        return Verify.IS_TRUE;
    }
}
