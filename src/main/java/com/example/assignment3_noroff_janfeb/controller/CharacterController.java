package com.example.assignment3_noroff_janfeb.controller;

import com.example.assignment3_noroff_janfeb.mappers.CharacterMapper;
import com.example.assignment3_noroff_janfeb.models.Character;
import com.example.assignment3_noroff_janfeb.models.dto.character.characterDTO;
import com.example.assignment3_noroff_janfeb.models.dto.character.characterPostDTO;
import com.example.assignment3_noroff_janfeb.services.characters.CharactersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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

    @PostMapping
    public ResponseEntity add(@RequestBody characterPostDTO entity){
        Character character = characterMapper.characterPostDTOToCharacter(entity);
        charactersService.add(character);
        URI uri = URI.create("api/v1/character/" + character.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody characterDTO entity, @PathVariable int id){
        if(id != entity.getId())
            return ResponseEntity.badRequest().build();

        Character character = characterMapper.characterDTOToCharacter(entity);
        charactersService.update(character);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable int id){
        charactersService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
