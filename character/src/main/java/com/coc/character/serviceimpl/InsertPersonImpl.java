package com.coc.character.serviceimpl;

import com.coc.character.mapper.UserPersonDoMapper;
import com.coc.character.pojo.UserPerson;
import com.coc.character.service.InsertPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ran_ych
 * @create 2019-12-30  16:53
 * @desc
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED) // Propagation事务传播行为
public class InsertPersonImpl implements InsertPerson {
    @Autowired
    private UserPersonDoMapper users;

    /**
     * 新增用户
     */
    @Override
    public int insertSelective(UserPerson record) {
        return users.insertSelective(record);
    }
}
