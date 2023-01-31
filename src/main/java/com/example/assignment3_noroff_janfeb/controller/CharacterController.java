package com.example.assignment3_noroff_janfeb.controller;

import com.example.assignment3_noroff_janfeb.mappers.CharacterMapper;
import com.example.assignment3_noroff_janfeb.services.characters.CharactersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/character")
public class CharacterController {
    private final CharactersService charactersService;
    private final CharacterMapper characterMapper;

    public CharacterController(CharactersService charactersService, CharacterMapper characterMapper) {
        this.charactersService = charactersService;
        this.characterMapper = characterMapper;
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        return ResponseEntity.ok(characterMapper.characterToCharacterDTO(charactersService.findById(id)));
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(characterMapper.characterToCharacterDTO(charactersService.findAll()));
    }
}
