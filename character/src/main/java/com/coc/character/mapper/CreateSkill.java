package com.coc.character.mapper;

import com.coc.character.pojo.People;
import com.coc.character.pojo.Skill;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ran_ych
 * @create 2019-10-13  14:54
 * @desc
 */
@Mapper
public interface CreateSkill {
     @Insert("INSERT INTO `character`.`skill` (`userid`,`hp`,`mp`,`name`, `potential`,`interest`, `san`, `currenthp`, `currentmp`, `currentsan`, `profession`,`mothertongue`,`dodge` ) VALUES\n" + "  ( #{userid}, #{hp}, #{mp}, #{name}, #{potential}, #{interest}, #{san},  #{hp},  #{mp}, #{san}, #{profession}, #{mothertongue}, #{dodge} )  ")
     public void addCharacterSkill(Skill character);

//     /*@Update("UPDATE `character`.`skill` SET #{potential},`interest` = #{interest},`shin` = #{shin},`swim` = #{swim},`spy` = #{spy},`listen` = #{listen},`libaray` = #{libaray},`negotiate` = #{negotiate}, `occultism` = #{occultism},`cthulhu` = #{cthulhu},`drive` = #{drive},`combat` = #{combat},`gun` = #{gun},`san` = #{san},`accountant` = #{san},`anthropology` = #{san}'anthropology',`evaluate` = #{san}'evaluate',`archeology` =#{san} 'archeology',`charm` = #{san}'charm',`computer` = #{san}'computer',`credit` = #{san}'credit', `dress` = #{san}'dress',`dodge` = #{san}'dodge',`electrical` = #{san}'electrical', `mechanology` = #{san}'mechanology',`law` = #{san}'law',`locksmith` = #{san}'locksmith',`sneak` = #{san}'sneak', `medical` = #{san}'medical',`foreign` = #{san}'foreign',`pilot` = #{san}'pilot',`psychology` = #{san}'psychology',`trace` = #{san}'trace',`aid` = #{san}'aid',`heavy` = #{san}'heavy',`steal` = #{san}'steal',`threaten` = #{san}'threaten',`chemistry` = #{san}'chemistry' where `userid` = #{userid} and `name`=#{name} ")
//     public void updateCharacterSkill(Skill skill);*/
}
