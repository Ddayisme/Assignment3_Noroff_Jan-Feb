package com.example.assignment3_noroff_janfeb.services.characters;

import com.example.assignment3_noroff_janfeb.models.Character;
import com.example.assignment3_noroff_janfeb.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Our implementation of the movie service. Which we use in the controller.
 * This layer connects to the database and performs querys behind the scenes through
 * the methods implemented.
 */
@Service
public class CharactersServiceImpl implements CharactersService{
    private final CharacterRepository characterRepository;

    public CharactersServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    /**
     * Find a single franchise object in the database with the specified id
     * @param id
     * @return
     */
    @Override
    public Character findById(Integer id) {
        return characterRepository.findById(id).get();
    }

    /**
     * Find all the Character objects in the database as a collection
     * @return
     */
    @Override
    public Collection<Character> findAll() {
        return characterRepository.findAll();
    }

    /**
     * Add a character object to the database
     * @param entity -is the character object
     * @return
     */
    @Override
    public Character add(Character entity) {
        return characterRepository.save(entity);
    }

    /**
     * Update a character object by using a whole new Character object as parameter
     * and updates the whole object with the specified id
     * @param entity
     * @return
     */
    @Override
    public Character update(Character entity) {
        return characterRepository.save(entity);
    }

    /**
     * Deleting a character object in the database with the specified id
     * @param id
     */
    @Override
    public void deleteById(Integer id) {

        characterRepository.deleteById(id);
    }

    /**
     * Helper method to check if the specified character object
     * exists in the database with the specified id.
     * @param id
     * @return
     */
    @Override
    public boolean exists(Integer id) {
        return characterRepository.existsById(id);
    }
}
