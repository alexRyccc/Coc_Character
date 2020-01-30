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
    @Insert("INSERT INTO `character`.`user` ( `name`,`str`, `agl`, `edu`, `phy`, `cha`, `vol`, `bod`, `bra`, `luck`, `sex`,`age`, `userid`, `birthplace`, `nationality`) VALUES(#{name},#{str},#{agl},#{edu},#{phy},#{cha},#{vol} ,#{bod},#{bra},#{luck},#{sex},#{age},#{userid} , #{birthplace}, #{nationality})")
    public int addCharacter(User character);

    @Select("SELECT A.name,A.userid,sex,age,str,agl,edu,phy,cha,vol,bra,luck,birthplace,nationality, `potential`, `interest`," +
            "shin, swim, spy, listen, libaray, negotiate, \n" + "    occultism, cthulhu, drive, combat, gun, san, currenthp, currentmp, currentsan, profession, \n" + "    accountant, anthropology, evaluate, archeology, charm, computer, credit, dress, dodge, \n" + "    electrical, mechanology, law, locksmith, sneak, medical, A.FOREIGN, pilot, psychology, \n" + "    trace, aid, heavy, steal, threaten, chemistry, trick, psychiatrist, naturalist, astronomy, \n" + "    phytology, cryptology, meteorology, engineering, geology, zoology, sword, spear, \n" + "    pistol, crossbow, gunnery, diving, throwing, jump, beasttraining, history, shorthand, \n" + "    falsify, lipread, maintenance, cooking, fire, farming, makesex, musictheory, puzzle, \n" + "    mothertongue, ohterone, othertwo, otherthree, otherfour, otherfive, othersix     FROM `character`.`skill` A,`character`.`user` B WHERE A.USERID =B.USERID AND A.userid =#{userid}")
    public People confirmCharacter(@Param("userid")String userid);
}
