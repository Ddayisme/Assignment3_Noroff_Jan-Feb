package com.example.assignment3_noroff_janfeb.mappers;


import com.example.assignment3_noroff_janfeb.models.Franchise;
import com.example.assignment3_noroff_janfeb.models.Movies;
import com.example.assignment3_noroff_janfeb.models.dto.movies.moviesDTO;
import com.example.assignment3_noroff_janfeb.services.franchise.FranchiseService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MovieMapper {



    @Mapping(target = "franchise", source="franchise.id")
    moviesDTO moviesToMoviesDTO(Movies movies);

    Collection<moviesDTO> moviesToMoviesDTO(Collection<Movies> movies);


    @Mapping(target="characters", ignore = true)
    @Mapping(target="franchise", ignore = true)
    Movies moviesDTOToMovie (moviesDTO moviesDto);

    @Named(value="franchiseToFranchiseId")
    default Set<Integer> map(Set<Franchise> value){
        if(value==null)
            return null;

        return value.stream()
                .map(s ->s.getId())
                .collect(Collectors.toSet());
    }




}
