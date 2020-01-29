package com.coc.character.mapper;

import com.coc.character.pojo.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper {
     public Person getselectByPrimaryKey(Person person);



}