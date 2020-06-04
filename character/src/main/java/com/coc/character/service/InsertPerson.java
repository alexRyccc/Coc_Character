package com.coc.character.service;

import com.coc.character.mapper.PersonMapper;
import com.coc.character.pojo.Person;
import com.coc.character.pojo.Userperson;

/**
 * @author ran_ych
 * @create 2019-12-30  16:52
 * @desc
 */
public interface InsertPerson {

    int insertSelective(Userperson record);


     Person personMapper(Person record);

     int getNumber(int id);


    Userperson selectUserPerson(Userperson record);

    Person getselect();
}
