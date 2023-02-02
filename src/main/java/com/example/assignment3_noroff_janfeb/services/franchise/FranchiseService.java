package com.example.assignment3_noroff_janfeb.services.franchise;

import com.example.assignment3_noroff_janfeb.models.Franchise;
import com.example.assignment3_noroff_janfeb.models.Movies;
import com.example.assignment3_noroff_janfeb.services.CRUDService;

import java.util.Collection;

public interface FranchiseService extends CRUDService<Franchise, Integer> {
    Franchise updateMoviesInAFranchise(int[] movieIds, int franchiseId);
    Collection<Movies> findAllMoviesInFranchise(int franchiseId);
}
