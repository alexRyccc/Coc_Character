package com.coc.character.serviceimpl;

import com.coc.character.Util.DateTimeUtils;
import com.coc.character.mapper.PersonMapper;
import com.coc.character.mapper.UserPersonDoMapper;
import com.coc.character.pojo.Person;
import com.coc.character.pojo.Userperson;
import com.coc.character.service.InsertPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author ran_ych
 * @create 2019-12-30  16:53
 * @desc
 */
@Service
@Transactional(propagation = Propagation.REQUIRED) // Propagation事务传播行为
public class InsertPersonImpl implements InsertPerson {
    @Autowired
    public UserPersonDoMapper users;

    @Autowired
    public PersonMapper personMapper;



    /**
     * 新增用户
     */
    @Override
    public int insertSelective(Userperson record) {
        record.setLevels(0);
        record.setRmk("注册时间："+ DateTimeUtils.getCurrentLocalDateTime());
        return users.insertSelective(record);
    }

    @Override
    public Person personMapper(Person record) {

        return personMapper.getselectByPrimaryKey(record);
    }

    @Override
    public int getNumber(int id) {
        return personMapper.getNumber(id);
    }

    @Override
    public Userperson selectUserPerson(Userperson record) {
        return users.selectUserPerson(record);
    }

    @Override
    public Person getselect() {
        return personMapper.getselect();
    }


}
