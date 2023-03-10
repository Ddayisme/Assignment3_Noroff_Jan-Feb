package com.example.assignment3_noroff_janfeb.controller;

import com.example.assignment3_noroff_janfeb.mappers.CharacterMapper;
import com.example.assignment3_noroff_janfeb.models.Character;
import com.example.assignment3_noroff_janfeb.models.Movies;
import com.example.assignment3_noroff_janfeb.models.dto.character.CharacterDTO;
import com.example.assignment3_noroff_janfeb.models.dto.character.CharacterPostDTO;
import com.example.assignment3_noroff_janfeb.models.dto.character.CharacterPutDTO;
import com.example.assignment3_noroff_janfeb.services.characters.CharactersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.HashSet;

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
    @Operation(summary = "Get a single character")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CharacterDTO.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
            )
    })
    public ResponseEntity findById(@PathVariable int id){
        return ResponseEntity.ok(characterMapper.characterToCharacterDTO(charactersService.findById(id)));
    }

    @GetMapping
    @Operation(summary = "Get all the characters")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema =@Schema (implementation = CharacterDTO.class)))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema=@Schema(implementation = ProblemDetail.class)))
            )
    })
    public ResponseEntity findAll(){
        return ResponseEntity.ok(characterMapper.characterToCharacterDTO(charactersService.findAll()));
    }

    @PostMapping
    @Operation(summary = "Adds a new character")
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = @Content
            )
    })
    public ResponseEntity add(@RequestBody CharacterPostDTO entity){
        Character character = characterMapper.characterPostDTOToCharacter(entity);
        charactersService.add(character);
        URI uri = URI.create("api/v1/character/" + character.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    @Operation(summary = "Updates a character")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Success",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content
            )
    })
    public ResponseEntity update(@RequestBody CharacterPutDTO entity, @PathVariable int id){
        if(id != entity.getId() || !charactersService.exists(id))
            return ResponseEntity.badRequest().build();

        Character character = characterMapper.characterPutDTOToCharacter(entity);
        charactersService.update(character);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletes a character")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Success",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content
            )
    })
    public ResponseEntity deleteById(@PathVariable int id){

        Character character= charactersService.findById(id);
        Collection<Movies> movies= new HashSet<>();

        movies.addAll(character.getMovies());
        for (Movies var: movies) {
            var.getCharacters().remove(character);
        }

        charactersService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
