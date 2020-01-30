package com.coc.character.serviceimpl;

import com.coc.character.mapper.CreateSkill;
import com.coc.character.mapper.SkillMapper;
import com.coc.character.mapper.UserMapper;
import com.coc.character.pojo.Skill;
import com.coc.character.service.CreateSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ran_ych
 * @create 2019-10-13  14:57
 * @desc
 */
@Service("createskill")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED) // Propagation事务传播行为
public class CreateSkillServiceImpl implements CreateSkillService {
    @Autowired
    private CreateSkill createSkill;

    @Autowired
    private SkillMapper skillMapper;



    @Override
    public void addCharacterSkill(Skill skill) {
        skillMapper.insertSelective(skill);
    }

    @Override
    public void updateCharacterSkill(Skill skill) {
        skillMapper.updateByPrimaryKeySelective(skill);
    }
}
