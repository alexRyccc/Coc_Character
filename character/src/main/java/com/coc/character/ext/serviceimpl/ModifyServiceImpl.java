package com.coc.character.ext.serviceimpl;

import com.coc.character.CharacterApplication;
import com.coc.character.Util.CopyUtils;
import com.coc.character.ext.service.ModifyServiceExt;
import com.coc.character.mapper.SkillMapper;
import com.coc.character.pojo.Skill;
import com.coc.character.pojo.req.SkillReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

/**
 * @author ran_ych
 * @create 2019-12-26  15:26
 * @desc
 */
@Service("ModifyServiceImpl")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class ModifyServiceImpl implements ModifyServiceExt {
    private static Logger logger = LoggerFactory.getLogger(CharacterApplication.class);
    @Resource
    private SkillMapper skillMapper;
    /**
     * @param skillReq
     * @return 修改技能点
     */
    @Override
    public int updateByPrimaryKeySelective(SkillReq skillReq) {
        Skill newSkill = CopyUtils.convertObject(skillReq,Skill.class);
        int result =0;
        if( (result =skillMapper.updateByPrimaryKeySelective(newSkill))!=1){
            logger.info("updateByPrimaryKeySelective is error");
            try {
                throw  new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;

    }
}
