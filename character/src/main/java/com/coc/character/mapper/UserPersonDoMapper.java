package com.coc.character.mapper;

import com.coc.character.pojo.Userperson;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserPersonDoMapper {
    

    /**
     *新增用户
     * @mbg.generated
     */
    int insertSelective(Userperson record);

    /**
     * 用户登录
     * @param userPerson
     * @return
     */

    public Userperson selectUserPerson(Userperson userPerson);

}