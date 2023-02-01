package com.example.assignment3_noroff_janfeb.services.movies;

import com.example.assignment3_noroff_janfeb.models.Movies;
import com.example.assignment3_noroff_janfeb.services.CRUDService;

public interface MoviesService extends CRUDService<Movies, Integer> {
    Movies addCharactersToMovie(int[] characterIds, int movieId);
}
