package com.coc.character.mapper;

import com.coc.character.pojo.Skill;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SkillMapper {
    /**
     *
     * @param record
     * @return 修改
     */
    int updateByPrimaryKeySelective(Skill record);
}