package com.coc.character.ext.service;

import com.coc.character.pojo.Person;
import com.coc.character.pojo.Userperson;




/**
 * @author ran_ych
 * @create 2019-12-25  10:48
 * @desc
 */
public interface QueryCharacterExt {

    /**
     * 验证Token是否存在
     */
    public String verifyToken(String token);


}
