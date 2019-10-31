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
     @Insert("INSERT INTO `character`.`skill` (`userid`,`hp`,`mp`,`name`, `potential`,`interest`,`shin`,`swim`,`spy`,`listen`, `libaray`, `negotiate`,`occultism`,`cthulhu`,`drive`, `combat`,`gun`, `san`, `currenthp`, `currentmp`, `currentsan`, `profession`, \n" + "  `accountant`, `anthropology`,`evaluate`,`archeology`,`charm`, `computer`,`credit`,`dress`,`dodge`,`electrical`, `mechanology`,`law`,`locksmith`, `sneak`, `medical`, `foreign`, `pilot`,`psychology`,`trace`,`aid`, `heavy`,`steal`,`threaten`, `chemistry`) VALUES\n" + "  ( #{userid}, #{hp}, #{mp}, #{name}, #{potential}, #{interest}, 20, 20, 20,  20, 5, 5, 1, 0,  5,  20,  5, #{san},  #{hp},  #{mp}, #{san}, #{profession},5 ,1, 5, 1, 15 ,10 ,1 ,10, 10, 1 ,1, 5 ,5, 20, 1, 5, 1 ,1 ,10, 20, 1,1 ,20 ,1)  ")
     public void addCharacterSkill(Skill character);

     @Update("UPDATE `character`.`skill` SET #{potential},`interest` = #{interest},`shin` = #{shin},`swim` = #{swim},`spy` = #{spy},`listen` = #{listen},`libaray` = #{libaray},`negotiate` = #{negotiate}, `occultism` = #{occultism},`cthulhu` = #{cthulhu},`drive` = #{drive},`combat` = #{combat},`gun` = #{gun},`san` = #{san},`accountant` = #{san},`anthropology` = #{san}'anthropology',`evaluate` = #{san}'evaluate',`archeology` =#{san} 'archeology',`charm` = #{san}'charm',`computer` = #{san}'computer',`credit` = #{san}'credit', `dress` = #{san}'dress',`dodge` = #{san}'dodge',`electrical` = #{san}'electrical', `mechanology` = #{san}'mechanology',`law` = #{san}'law',`locksmith` = #{san}'locksmith',`sneak` = #{san}'sneak', `medical` = #{san}'medical',`foreign` = #{san}'foreign',`pilot` = #{san}'pilot',`psychology` = #{san}'psychology',`trace` = #{san}'trace',`aid` = #{san}'aid',`heavy` = #{san}'heavy',`steal` = #{san}'steal',`threaten` = #{san}'threaten',`chemistry` = #{san}'chemistry' where `userid` = #{userid} and `name`=#{name} ")
     public void updateCharacterSkill(Skill skill);
}
