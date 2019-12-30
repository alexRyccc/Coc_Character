package com.coc.character.ext.service;

import com.coc.character.pojo.Person;
import com.coc.character.pojo.UserPerson;


/**
 * @author ran_ych
 * @create 2019-12-25  10:48
 * @desc
 */
public interface QueryCharacterExt {
    /*
    通过id和姓名查询用户信息
     */
    Person selectByPrimaryKey(Person person);

    UserPerson selectUserPerson(UserPerson userPerson);
}
