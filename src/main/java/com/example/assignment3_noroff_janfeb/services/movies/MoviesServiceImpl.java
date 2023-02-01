package com.example.assignment3_noroff_janfeb.services.movies;

import com.example.assignment3_noroff_janfeb.models.Character;
import com.example.assignment3_noroff_janfeb.models.Movies;
import com.example.assignment3_noroff_janfeb.repositories.CharacterRepository;
import com.example.assignment3_noroff_janfeb.repositories.MoviesRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MoviesServiceImpl implements MoviesService {

    private final MoviesRepository moviesRepository;
    private final CharacterRepository characterRepository;

    public MoviesServiceImpl(MoviesRepository moviesRepository, CharacterRepository characterRepository) {
        this.moviesRepository = moviesRepository;
        this.characterRepository = characterRepository;
    }

    @Override
    public Movies findById(Integer id) {
        return moviesRepository.findById(id).get();
    }

    @Override
    public Collection<Movies> findAll() {
        return moviesRepository.findAll();
    }

    @Override
    public Movies add(Movies entity) {
        return moviesRepository.save(entity);
    }

    @Override
    public Movies update(Movies entity) {
        return moviesRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        moviesRepository.deleteById(id);
    }

    @Override
    public boolean exists(Integer id) {
        return moviesRepository.existsById(id);
    }

    @Override
    public Movies addCharactersToMovie(int[] characterIds, int movieId){
        Movies movies = moviesRepository.findById(movieId).get();
        for(int i = 0; i < characterIds.length; i++){
            Character character = characterRepository.findById(characterIds[i]).get();
            movies.getCharacters().add(character);
        }
        return moviesRepository.save(movies);
    }
}
