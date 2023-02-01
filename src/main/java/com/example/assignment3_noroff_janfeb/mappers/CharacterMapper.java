package com.example.assignment3_noroff_janfeb.mappers;

import com.example.assignment3_noroff_janfeb.models.Character;
import com.example.assignment3_noroff_janfeb.models.Movies;
import com.example.assignment3_noroff_janfeb.models.dto.character.characterDTO;
import com.example.assignment3_noroff_janfeb.models.dto.character.characterPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CharacterMapper {

    @Mapping(target = "movies", qualifiedByName = "moviesToMoviesId")
    characterDTO characterToCharacterDTO(Character character);

    Collection<characterDTO> characterToCharacterDTO(Collection<Character> characters);

    @Mapping(target = "movies", ignore = true)
    Character characterDTOToCharacter(characterDTO characterDto);

    Character characterPostDTOToCharacter(characterPostDTO characterPostDto);

    @Named(value = "moviesToMoviesId")
    default Set<Integer> map(Set<Movies> values){
        if(values == null)
            return null;

        return values.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
}
