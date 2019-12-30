package com.coc.character.ext.serviceimpl;

import com.coc.character.Util.CopyUtils;
import com.coc.character.ext.service.CreateCharacterServiceExt;
import com.coc.character.pojo.People;
import com.coc.character.pojo.Skill;
import com.coc.character.pojo.User;
import com.coc.character.service.CreateCharacterService;
import com.coc.character.service.CreateSkillService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author ran_ych
 * @create 2019-10-12  16:51
 * @desc
 */
@Service("createCharacterExt")
public class CreateCharacterServiceExtImpl implements CreateCharacterServiceExt {
    @Resource
    private CreateCharacterService createCharacterService;

    @Resource
    private CreateSkillService createSkillService;



    /**
     * 创建用户
     */


    @Override
    @Transactional(rollbackFor=Exception.class)
    public People insertCharacter(User user, Skill sk) {
        User character =new User();
        CopyUtils.copyProperties(user,character);
        Skill skill =new Skill();
        CopyUtils.copyProperties(user,skill);
        //得到力量
        int str =character.common();
        //得到敏捷
        int agl =character.common();
        //教育水平
        int edu =character.common();
        //体质水平
        int phy =character.common();
        //人格魅力
        int cha =character.common();
        //意志力
        int vol =character.common();
        //体格
        int bod =character.special();
        //灵感智力
        int bar =character.special();
        //运气
        int luck =character.luck();
        //hp=体质+体格/10
        int hp=(phy+bod)/10;
        //mp =灵感/10
        int mp=bar/10;
        //san值==意志力
        int san =vol;
        //兴趣点==智力*2;
        int interest =bar*2;
        /**潜力点根据职业不同而不同
         * 这里进行设定1：工农阶级 2无产阶级 3军人阶级 4资本家阶级 5科技工作者 6其他
         * 工农阶级   潜力=力量*2+敏捷*2
         * 无产阶级   潜力=教育*2+敏捷*2
         * 军人阶级   潜力=教育*2+力量*2
         * 资本家阶级  潜力=教育*2+魅力*2
         * 科技工作者  潜力=教育*2+智力*2
         * 其他       潜力=教育*4
         *
         */

        int potential =getpotential(sk.getProfession(),str,agl,edu,cha,bar);

        skill.setProfession(sk.getProfession());
        skill.setPotential(potential);
        skill.setInterest(interest);
        skill.setHp(hp);
        skill.setCurrenthp(hp);
        skill.setMp(mp);
        skill.setCurrentmp(mp);
        skill.setSan(san);
        skill.setCurrentsan(san);


        character.setStr(str);
        character.setAgl(agl);
        character.setEdu(edu);
        character.setPhy(phy);
        character.setCha(cha);
        character.setVol(vol);
        character.setBod(bod);
        character.setBra(bar);
        character.setLuck(luck);
        createCharacterService.addCharacter(character);
        createSkillService.addCharacterSkill(skill);
        People user1  =createCharacterService.confirmCharacter(character.getUserid());

        return user1;
    }

    /**
     * 基础状态加技能
     *
     * @param skill
     */
    @Override
    public void updateCharacterSkill(Skill skill) {
        if (skill.getInterest()<0&&skill.getPotential()<0){
            System.out.println("技能加点失败");
        }else {
            createSkillService.updateCharacterSkill(skill);
        }

    }

    private int getpotential(String profession, int str, int gal, int edu, int cha, int bar ){
        int potential =0;

        switch (profession){
            case "1":
                potential =(str+gal)*2;
                break;
            case "2":
                potential =(edu+gal)*2;
                break;
            case "3":
                potential =(str+edu)*2;
                break;
            case "4":
                potential =(edu+cha)*2;
                break;
            case "5":
                potential =(edu+bar)*2;
                break;
            default:
                potential = edu*4;
                break;

        }

        return potential;
    }

}
