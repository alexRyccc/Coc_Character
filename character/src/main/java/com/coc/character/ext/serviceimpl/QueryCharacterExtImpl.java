package com.coc.character.ext.serviceimpl;

import com.coc.character.ext.service.QueryCharacterExt;
import com.coc.character.mapper.PersonMapper;
import com.coc.character.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ran_ych
 * @create 2019-12-25  10:50
 * @desc
 */
@Service("QueryCharacterExtImpl")
public class QueryCharacterExtImpl implements QueryCharacterExt {
    @Resource
    private PersonMapper personMapper;

    @Override
    public Person selectByPrimaryKey(Person person) {
       return personMapper.getselectByPrimaryKey(person);
    }
}
