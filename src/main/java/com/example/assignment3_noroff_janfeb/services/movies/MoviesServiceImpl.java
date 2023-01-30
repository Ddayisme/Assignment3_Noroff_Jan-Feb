package com.example.assignment3_noroff_janfeb.services.movies;

import com.example.assignment3_noroff_janfeb.models.Movies;
import com.example.assignment3_noroff_janfeb.repositories.MoviesRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MoviesServiceImpl implements MoviesService {

    private final MoviesRepository moviesRepository;

    public MoviesServiceImpl(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @Override
    public Movies findById(Integer integer) {
        return moviesRepository.findById(integer).get();
    }

    @Override
    public Collection<Movies> findAll() {
        return null;
    }

    @Override
    public Movies add(Movies entity) {
        return null;
    }

    @Override
    public Movies update(Movies entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }
}
