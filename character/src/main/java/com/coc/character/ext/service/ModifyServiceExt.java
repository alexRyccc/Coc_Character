package com.coc.character.ext.service;

import com.coc.character.pojo.Skill;
import com.coc.character.pojo.req.SkillReq;

/**
 * @author ran_ych
 * @create 2019-12-26  15:25
 * @desc
 */
public interface ModifyServiceExt {
    /**
     *
     * @param record
     * @return 修改
     */
    int updateByPrimaryKeySelective(SkillReq record);
}
