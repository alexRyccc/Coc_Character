package com.coc.character.service;

import com.coc.character.pojo.Skill;

/**
 * @author ran_ych
 * @create 2019-10-13  14:55
 * @desc
 */
public interface CreateSkillService {
    public void addCharacterSkill(Skill skill);

    public void updateCharacterSkill(Skill skill);
}
