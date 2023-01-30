package com.example.assignment3_noroff_janfeb.mappers;


import com.example.assignment3_noroff_janfeb.models.Franchise;
import com.example.assignment3_noroff_janfeb.models.Movies;
import com.example.assignment3_noroff_janfeb.models.dto.movies.moviesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(target = "franchise", source="franchise.id")
    moviesDTO moviesToMoviesDTO(Movies movies);

    Collection<moviesDTO> moviesToMoviesDTO(Collection<Movies> movies);

    @Named(value="franchiseToFranchiseId")
    default Set<Integer> map(Set<Franchise> value){
        if(value==null)
            return null;

        return value.stream()
                .map(s ->s.getId())
                .collect(Collectors.toSet());
    }
}
