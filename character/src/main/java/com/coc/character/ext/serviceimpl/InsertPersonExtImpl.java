package com.coc.character.ext.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coc.character.Util.String.StringUtil;
import com.coc.character.Util.enums.TimeEnums;
import com.coc.character.Util.redis.RedisUtil;
import com.coc.character.ext.service.InsertPersonExt;
import com.coc.character.pojo.Person;
import com.coc.character.pojo.Userperson;
import com.coc.character.service.InsertPerson;
import com.coc.character.ext.service.SmsServiceExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author ran_ych
 * @create 2019-12-30  17:03
 * @desc
 */
@Service("insertpersonextimpl")
public class InsertPersonExtImpl implements InsertPersonExt {
    private static Logger logger = LoggerFactory.getLogger(InsertPersonExtImpl.class);

    @Resource
    public InsertPerson insertPerson;
    @Resource
    public SmsServiceExt smsServiceExt;


    @Autowired
    public RedisUtil redisUtil;


    /**
     * 新增用户
     * @param record
     * @mbg.generated
     */
    @Override
    public int insertSelective(Userperson record) {
        int  c =1;
        if ((c =checkMassger(record))!=1){
            return  c;
        }

        //1 不区分大小写（统一改为小写）
        record.setPassword(record.changePassword(record.getPassword()));

         c =insertPerson.insertSelective(record);

        return c;
    }

    /**
     * 用户登录
     *
     * @param record
     * @mbg.generated
     */
    @Override
    public int registerPeople(Userperson record) {

        return 1;
    }

    private int checkMassger(Userperson record){
        int c =1;
        if(!record.haveTruePassword()){
            c=-2;
            return c;
        }
        if (!record.haveTrueUsername()){
            c=-1;
            return c;
        }
        if (!record.haveTruePhone()){
            c =-3;
            return c;
        }

        return c;
    }


    @Override
    public Person selectByPrimaryKey(Person person) {
        int a=0;
        int b=1;
        return insertPerson.personMapper(person);
    }

    @Override
    public Userperson selectUserPerson(Userperson userPerson) {
        //1、判断是否是手机号登录
        String phoneTrue =userPerson.getPhones();

        if(phoneTrue.equals("1")){
            //手机号登录
        }else{
            //正常登录

        }
        //2、判断是否保持登录
        String token = UUID.randomUUID().toString();

        userPerson.setToken(token);
        String user = JSON.toJSONString(userPerson);


        logger.info("token：{}---user:{}",token,user);
        int times =0;
        if ("on".equals(userPerson.getSave())){
             times = TimeEnums.LOGINSIGN;
        }else{
            times =TimeEnums.SEXMINUTE;
        }
        String rediskey="REDIS_SESSION_KEY" + userPerson.getUsername();
        logger.info("rediskey:{}",rediskey);
        Object o = redisUtil.get(rediskey);
        if(o==null){

                redisUtil.set(rediskey, user,times );

        }else{
                redisUtil.expire(rediskey,times);
            }
        //将token设置入代码
        Userperson userperson1 =  insertPerson.selectUserPerson(userPerson);
        userperson1.setToken(rediskey);
        return userperson1;
    }

    /**
     * 通过token查询是否在线
     *
     * @param token
     */

    @Override
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

    @Override
    public Person select() {
        System.out.println("select");
        return insertPerson.getselect();
    }

    @Override
    public int getNumber(int id) {
        return insertPerson.getNumber(id);
    }
}
