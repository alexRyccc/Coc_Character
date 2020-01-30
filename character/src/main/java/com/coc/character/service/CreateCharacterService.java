package com.coc.character.service;

import com.coc.character.pojo.People;
import com.coc.character.pojo.User;

/**
 * @author ran_ych
 * @create 2019-10-12  16:40
 * @desc
 */
public interface CreateCharacterService {
    public int addCharacter(User character);

    public People confirmCharacter(String userid);
}
