package com.example.assignment3_noroff_janfeb.controller;

import com.example.assignment3_noroff_janfeb.mappers.MovieMapper;
import com.example.assignment3_noroff_janfeb.models.Movies;
import com.example.assignment3_noroff_janfeb.services.movies.MoviesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/movies")
public class MoviesController {

    private final MoviesService moviesService;
    private final MovieMapper movieMapper;

    public MoviesController(MoviesService moviesService, MovieMapper movieMapper) {

        this.moviesService = moviesService;
        this.movieMapper = movieMapper;
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        return ResponseEntity.ok(
                movieMapper.moviesToMoviesDTO(
                        moviesService.findById(id)));
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(
                movieMapper.moviesToMoviesDTO(
                        moviesService.findAll()
                )
        );
    }

}
