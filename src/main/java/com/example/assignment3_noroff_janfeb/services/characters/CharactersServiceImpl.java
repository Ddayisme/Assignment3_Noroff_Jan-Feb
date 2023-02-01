package com.example.assignment3_noroff_janfeb.services.characters;

import com.example.assignment3_noroff_janfeb.models.Character;
import com.example.assignment3_noroff_janfeb.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CharactersServiceImpl implements CharactersService{

    private final CharacterRepository characterRepository;

    public CharactersServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public Character findById(Integer integer) {
        return characterRepository.findById(integer).get();
    }

    @Override
    public Collection<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public Character add(Character entity) {
        return characterRepository.save(entity);
    }

    @Override
    public Character update(Character entity) {
        return characterRepository.save(entity);
    }

    @Override
    public void deleteById(Integer integer) {
        characterRepository.deleteById(integer);
    }

    @Override
    public boolean exists(Integer integer) {
        return characterRepository.existsById(integer);
    }
}
