package com.coc.character.ext.service;

import com.coc.character.pojo.Person;
import com.coc.character.pojo.Userperson;

/**
 * @author ran_ych
 * @create 2019-12-30  17:03
 * @desc
 */
public interface InsertPersonExt {
    /**
     *新增用户
     * @mbg.generated
     */
    int insertSelective(Userperson record);

    /**
     *用户登录
     * @mbg.generated
     */
    int registerPeople(Userperson record);

    /*
   通过id和姓名查询用户信息
    */
    Person selectByPrimaryKey(Person person);

    Userperson selectUserPerson(Userperson userPerson);

    /**
     * 通过token查询是否在线
     */
    Userperson getByToken(String token);

    Person select();

    int getNumber(int id);
}
