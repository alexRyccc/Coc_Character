package com.coc.character.ext.serviceimpl;

import com.coc.character.ext.service.InsertPersonExt;
import com.coc.character.pojo.UserPerson;
import com.coc.character.service.InsertPerson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ran_ych
 * @create 2019-12-30  17:03
 * @desc
 */
@Service("insertpersonextimpl")
public class InsertPersonExtImpl implements InsertPersonExt {

    @Resource
    private InsertPerson insertPerson;

    /**
     * 新增用户
     * @param record
     * @mbg.generated
     */
    @Override
    public int insertSelective(UserPerson record) {
        int  c =1;
        if ((c =checkMassger(record))!=1){
            return  c;
        }
        //1 不区分大小写（统一改为小写）
        record.setPassword(record.changePassword(record.getPassword()));

         c =insertPerson.insertSelective(record);

        return c;
    }

    private int checkMassger(UserPerson record){
        int c =1;
        if(!record.haveTruePassword()){
            c=-2;
            return c;
        }
        if (!record.haveTrueUsername()){
            c=-1;
            return c;
        }
        if (!record.haveTruePhone()){
            c =-3;
            return c;
        }

        return c;
    }
}
