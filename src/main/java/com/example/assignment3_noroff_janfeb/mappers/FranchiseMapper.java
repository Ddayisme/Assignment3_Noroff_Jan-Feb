package com.example.assignment3_noroff_janfeb.mappers;

import com.example.assignment3_noroff_janfeb.models.Franchise;
import com.example.assignment3_noroff_janfeb.models.Movies;
import com.example.assignment3_noroff_janfeb.models.dto.franchise.franchiseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {
    @Mapping(target = "movies", qualifiedByName = "moviesToMoviesId")
    franchiseDTO franchiseToFranchiseDTO(Franchise franchise);

    Collection<franchiseDTO> franchiseToFranchiseDTO(Collection<Franchise> franchises);

    @Mapping(target = "movies", ignore = true )
    Franchise franchiseDTOToFranchise(franchiseDTO franchiseDto);

    @Named(value = "moviesToMoviesId")
    default Set<Integer> map(Set<Movies> value) {
        if (value == null)
            return null;
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
}
