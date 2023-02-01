package com.example.assignment3_noroff_janfeb.controller;

import com.example.assignment3_noroff_janfeb.mappers.MovieMapper;
import com.example.assignment3_noroff_janfeb.models.Movies;
import com.example.assignment3_noroff_janfeb.models.dto.movies.moviesDTO;
import com.example.assignment3_noroff_janfeb.services.movies.MoviesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity add(@RequestBody moviesDTO entity){
        Movies movie = movieMapper.moviesDTOToMovie(entity);
        moviesService.add(movie);
        URI uri = URI.create("api/v1/movies/" +movie.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody moviesDTO entity, @PathVariable int id) {

        if (id != entity.getId())
            return ResponseEntity.badRequest().build();

        Movies movie = movieMapper.moviesDTOToMovie(entity);
        moviesService.update(movie);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable int id){
                moviesService.deleteById(id);
                return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public boolean exists(@PathVariable int id){
        Movies movie= moviesService.findById(id);
        if(movie!=null)
            return true;
        return false;
    }

}
