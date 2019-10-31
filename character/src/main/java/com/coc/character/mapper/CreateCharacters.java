package com.coc.character.mapper;

import com.coc.character.pojo.People;
import com.coc.character.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author ran_ych
 * @create 2019-10-12  16:20
 * @desc
 */
@Mapper
public interface CreateCharacters {
    @Insert("INSERT INTO `character`.`user` ( `name`,`str`, `agl`, `edu`, `phy`, `cha`, `vol`, `bod`, `bra`, `luck`, `sex`,`age`, `userid`) VALUES(#{name},#{str},#{agl},#{edu},#{phy},#{cha},#{vol} ,#{bod},#{bra},#{luck},#{sex},#{age},#{userid})")
    public void addCharacter(User character);

    @Select("SELECT A.name,A.userid,sex,age,str,agl,edu,phy,cha,vol,bra,luck, `potential`, `interest`, `shin`, `swim`, `spy`, `listen`,`libaray`,`negotiate`,`occultism`,`cthulhu`,`drive`,`combat`,`gun`,hp,`currenthp`,mp,`currentmp`,san,`currentsan`, `profession` ,`accountant`,`anthropology`,`evaluate`,`archeology`,`charm`,`computer`,`credit`,`dress`,`dodge`, `electrical`,`mechanology`,`law`, `locksmith`, `sneak`, `medical`, `foreign`, `pilot`, `psychology`, `trace`, `aid`, `heavy`, `steal`,`threaten`, `chemistry`  FROM `character`.`skill` A,`character`.`user` B WHERE A.USERID =B.USERID AND A.userid =#{userid}")
    public People confirmCharacter(@Param("userid")String userid);
}
