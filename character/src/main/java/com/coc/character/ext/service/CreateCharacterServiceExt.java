package com.coc.character.ext.service;

import com.coc.character.pojo.People;
import com.coc.character.pojo.Skill;
import com.coc.character.pojo.User;

/**
 * @author ran_ych
 * @create 2019-10-12  16:49
 * @desc
 */
public interface CreateCharacterServiceExt {
    /**
     * 创建用户
     */
    People insertCharacter(User user, Skill skill);

    /**
     * 基础状态加技能
     * @param skill
     */
    public void updateCharacterSkill(Skill skill);
}
