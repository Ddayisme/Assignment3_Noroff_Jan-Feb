package com.example.assignment3_noroff_janfeb.controller;

import com.example.assignment3_noroff_janfeb.mappers.CharacterMapper;
import com.example.assignment3_noroff_janfeb.mappers.MovieMapper;
import com.example.assignment3_noroff_janfeb.models.Movies;
import com.example.assignment3_noroff_janfeb.models.dto.character.CharacterDTO;
import com.example.assignment3_noroff_janfeb.models.dto.movies.MoviesDTO;
import com.example.assignment3_noroff_janfeb.models.dto.movies.MoviesPostDTO;
import com.example.assignment3_noroff_janfeb.models.dto.movies.MoviesPutDTO;
import com.example.assignment3_noroff_janfeb.services.movies.MoviesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "api/v1/movies")
public class MoviesController {
    private final MoviesService moviesService;
    private final MovieMapper movieMapper;

    private final CharacterMapper characterMapper;

    public MoviesController(MoviesService moviesService, MovieMapper movieMapper, CharacterMapper characterMapper) {
        this.moviesService = moviesService;
        this.movieMapper = movieMapper;
        this.characterMapper = characterMapper;
    }

    @GetMapping("{id}")
    @Operation(summary = "Get a single movie")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MoviesDTO.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
            )
    })
    public ResponseEntity findById(@PathVariable int id){
        return ResponseEntity.ok(
                movieMapper.moviesToMoviesDTO(
                        moviesService.findById(id)));
    }

    @GetMapping
    @Operation(summary = "Get all the movies")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                            array = @ArraySchema(schema =@Schema (implementation = MoviesDTO.class)))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(mediaType = "application/json",
                            schema=@Schema(implementation = ProblemDetail.class))
            )
    })
    public ResponseEntity findAll() {
        return ResponseEntity.ok(
                movieMapper.moviesToMoviesDTO(
                        moviesService.findAll()
                )
        );
    }

    @PostMapping
    @Operation(summary = "Adds a new movie")
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = @Content
            )
    })
    public ResponseEntity add(@RequestBody MoviesPostDTO entity){
        Movies movie = movieMapper.moviesPostDTOToMovies(entity);
        moviesService.add(movie);
        URI uri = URI.create("api/v1/movies/" +movie.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    @Operation(summary = "Updates a movie")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Success",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content
            )
    })
    public ResponseEntity update(@RequestBody MoviesPutDTO entity, @PathVariable int id) {

        if (id != entity.getId() || !moviesService.exists(id))
            return ResponseEntity.badRequest().build();

        Movies movie = movieMapper.moviesPutDTOToMovies(entity);
        moviesService.update(movie);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletes a movie")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Success",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content
            )
    })
    public ResponseEntity deleteById(@PathVariable int id){
        moviesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}/character")
    @Operation(summary = "Updates characters in a movie")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Success",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Server error",
                    content = @Content
            )
    })
    public ResponseEntity updateCharactersInMovies(@PathVariable int id, @RequestBody int[] characters){
        if(!moviesService.exists(id))
            return ResponseEntity.badRequest().build();
        moviesService.addCharactersToMovie(characters, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}/characters")
    @Operation(summary = "Get all characters in a movie")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema=@Schema(implementation = CharacterDTO.class)))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(mediaType = "application/json",
                            schema=@Schema(implementation = ProblemDetail.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(mediaType = "application/json",
                            schema=@Schema(implementation = ProblemDetail.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Server error",
                    content = @Content(mediaType = "application/json",
                            schema=@Schema(implementation = ProblemDetail.class))
            )
    })
    public ResponseEntity allCharactersInAMovie(@PathVariable int id){
        return ResponseEntity.ok(
                characterMapper.characterToCharacterDTO(
                        moviesService.allCharactersInMovie(id)
                ));

    }
}
