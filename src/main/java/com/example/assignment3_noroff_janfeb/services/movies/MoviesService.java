package com.example.assignment3_noroff_janfeb.services.movies;

import com.example.assignment3_noroff_janfeb.models.Character;
import com.example.assignment3_noroff_janfeb.models.Movies;
import com.example.assignment3_noroff_janfeb.services.CRUDService;

import javax.xml.stream.events.Characters;
import java.util.Collection;


public interface MoviesService extends CRUDService<Movies, Integer> {
    Movies addCharactersToMovie(int[] characterIds, int movieId);

    Collection<Character> allCharactersInMovie(int movieId);
}
