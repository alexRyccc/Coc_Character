package com.coc.character.serviceimpl;

import com.coc.character.mapper.CreateCharacters;
import com.coc.character.pojo.People;
import com.coc.character.pojo.User;
import com.coc.character.service.CreateCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ran_ych
 * @create 2019-10-12  16:42
 * @desc
 */
@Service("createCharacter")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED) // Propagation事务传播行为
public class CreateCharacterServiceImpl implements CreateCharacterService {
    @Autowired
    CreateCharacters createCharacter;

    @Override
    public void addCharacter(User character) {
        createCharacter.addCharacter(character);

    }

    @Override
    public People confirmCharacter(String userid) {
        return createCharacter.confirmCharacter(userid);
    }
}
