package com.example.assignment3_noroff_janfeb.mappers;

import com.example.assignment3_noroff_janfeb.models.Franchise;
import com.example.assignment3_noroff_janfeb.models.Movies;
import com.example.assignment3_noroff_janfeb.models.dto.franchise.FranchiseDTO;
import com.example.assignment3_noroff_janfeb.models.dto.franchise.FranchisePostDTO;
import com.example.assignment3_noroff_janfeb.models.dto.franchise.FranchisePutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Our franchise mapper which helps us map from a franchise class to a franchiseDTO and back.
 * It also helps with presenting classes as id's instead of a whole object.
 */
@Mapper(componentModel = "spring")
public interface FranchiseMapper {
    @Mapping(target = "movies", qualifiedByName = "moviesToMoviesId")
    FranchiseDTO franchiseToFranchiseDTO(Franchise franchise);

    Collection<FranchiseDTO> franchiseToFranchiseDTO(Collection<Franchise> franchises);

    Franchise franchisePutDTOToFranchise(FranchisePutDTO franchisePutDTO);

    Franchise franchisePostDTOToFranchise(FranchisePostDTO franchisePostDTO);

    @Named(value = "moviesToMoviesId")
    default Set<Integer> map(Set<Movies> value) {
        if (value == null)
            return null;
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
}
