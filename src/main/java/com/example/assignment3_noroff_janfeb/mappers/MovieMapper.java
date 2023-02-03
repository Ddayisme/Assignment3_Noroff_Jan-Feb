package com.example.assignment3_noroff_janfeb.mappers;


import com.example.assignment3_noroff_janfeb.models.Character;
import com.example.assignment3_noroff_janfeb.models.Movies;
import com.example.assignment3_noroff_janfeb.models.dto.movies.MoviesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Our movie mapper which helps us map from a movie class to a movieDTO and back.
 * It also helps with presenting classes as id's instead of a whole object.
 */
@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mapping(target = "franchise", source="franchise.id")
    @Mapping(target = "characters", qualifiedByName = "characterToCharacterId")
    MoviesDTO moviesToMoviesDTO(Movies movies);

    Collection<MoviesDTO> moviesToMoviesDTO(Collection<Movies> movies);

    @Mapping(target="franchise", ignore = true)
    @Mapping(target="characters", ignore = true)
    Movies moviesDTOToMovie (MoviesDTO moviesDto);

    @Named(value = "characterToCharacterId")
    default Set<Integer> map(Set<Character> value){
        if(value==null)
            return null;

        return value.stream()
                .map(s ->s.getId())
                .collect(Collectors.toSet());
    }
}
