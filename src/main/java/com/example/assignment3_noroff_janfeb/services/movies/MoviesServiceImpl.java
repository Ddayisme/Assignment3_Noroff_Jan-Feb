package com.example.assignment3_noroff_janfeb.services.movies;

import com.example.assignment3_noroff_janfeb.models.Character;
import com.example.assignment3_noroff_janfeb.models.Movies;
import com.example.assignment3_noroff_janfeb.repositories.CharacterRepository;
import com.example.assignment3_noroff_janfeb.repositories.MoviesRepository;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Characters;
import java.util.Collection;
import java.util.HashSet;
/**
 * Our implementation of the movie service. Which we use in the controller.
 * This layer connects to the database and performs querys behind the scenes through
 * the methods implemented.
 */
@Service
public class MoviesServiceImpl implements MoviesService {

    /**
     * Our final fields being implemented with dependency injections
     */
    private final MoviesRepository moviesRepository;
    private final CharacterRepository characterRepository;

    public MoviesServiceImpl(MoviesRepository moviesRepository, CharacterRepository characterRepository) {
        this.moviesRepository = moviesRepository;
        this.characterRepository = characterRepository;
    }

    /**
     * Find a single Movie object in the database with the specified id
     * @param id
     * @return
     */
    @Override
    public Movies findById(Integer id) {
        return moviesRepository.findById(id).get();
    }

    /**
     * Find all the movie objects in the database as a collection
     * @return
     */
    @Override
    public Collection<Movies> findAll() {
        return moviesRepository.findAll();
    }

    /**
     * Add a movie object to the database
     * @param entity -is the Movies object
     * @return
     */
    @Override
    public Movies add(Movies entity) {
        return moviesRepository.save(entity);
    }

    /**
     * Update a movie object by using a whole new Movies object as parameter
     * and updates the whole object with the specified id
     * @param entity
     * @return
     */

    @Override
    public Movies update(Movies entity) {
        return moviesRepository.save(entity);
    }

    /**
     * Deleting a movie object in the database with the specified id
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        moviesRepository.deleteById(id);
    }

    /**
     * Helper method to check if the specified Movie object exists
     * in the database with the specified id.
     * @param id
     * @return
     */

    @Override
    public boolean exists(Integer id) {
        return moviesRepository.existsById(id);
    }

    /**
     * The method sets new values in the character field in the Movie object
     * @param characterIds - An array with character Id's
     * @param movieId -  The movie id to be updated
     * @return
     */
    @Override
    public Movies addCharactersToMovie(int[] characterIds, int movieId){
        Movies movies = moviesRepository.findById(movieId).get();
        for(int i = 0; i < characterIds.length; i++){
            Character character = characterRepository.findById(characterIds[i]).get();
            movies.getCharacters().add(character);
        }
        return moviesRepository.save(movies);
    }

    /**
     * Get all characters in the specified movie as a Collection of characters
     * @param movieId
     * @return
     */
    @Override
    public Collection<Character> allCharactersInMovie(int movieId) {

        Movies movie= moviesRepository.findById(movieId).get();

        return new HashSet<>(movie.getCharacters());

    }
}
