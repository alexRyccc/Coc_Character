package com.coc.character.ext.service;

import com.coc.character.pojo.UserPerson;

/**
 * @author ran_ych
 * @create 2020-01-22  20:46
 * @desc
 */
public interface SignServiceExt {
    /**
     * 用户登录
     * @param userPerson
     */
    int SignPerson (UserPerson userPerson);
}