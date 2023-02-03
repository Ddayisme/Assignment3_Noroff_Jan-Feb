package com.example.assignment3_noroff_janfeb.mappers;

import com.example.assignment3_noroff_janfeb.models.Character;
import com.example.assignment3_noroff_janfeb.models.Movies;
import com.example.assignment3_noroff_janfeb.models.dto.character.CharacterDTO;
import com.example.assignment3_noroff_janfeb.models.dto.character.CharacterPostDTO;
import com.example.assignment3_noroff_janfeb.models.dto.character.CharacterPutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Our character mapper which helps us map from a character class to a characterDTO and back.
 * It also helps with presenting classes as id's instead of a whole object.
 */
@Mapper(componentModel = "spring")
public interface CharacterMapper {

    @Mapping(target = "movies", qualifiedByName = "moviesToMoviesId")
    CharacterDTO characterToCharacterDTO(Character character);

    Collection<CharacterDTO> characterToCharacterDTO(Collection<Character> characters);

    Character characterPutDTOToCharacter(CharacterPutDTO characterPutDto);

    Character characterPostDTOToCharacter(CharacterPostDTO characterPostDto);

    @Named(value = "moviesToMoviesId")
    default Set<Integer> map(Set<Movies> values){
        if(values == null)
            return null;

        return values.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
}
