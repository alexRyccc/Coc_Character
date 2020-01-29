package com.coc.character.ext.service;

import com.coc.character.pojo.Userperson;

/**
 * @author ran_ych
 * @create 2020-01-22  20:46
 * @desc
 */
public interface SMSSignServiceExt {
    /**
     * 用户登录
     * @param userPerson
     */
    int SignPerson (Userperson userPerson);
}