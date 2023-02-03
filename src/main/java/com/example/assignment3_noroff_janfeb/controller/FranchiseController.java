package com.example.assignment3_noroff_janfeb.controller;

import com.example.assignment3_noroff_janfeb.mappers.CharacterMapper;
import com.example.assignment3_noroff_janfeb.mappers.FranchiseMapper;
import com.example.assignment3_noroff_janfeb.mappers.MovieMapper;
import com.example.assignment3_noroff_janfeb.models.Franchise;
import com.example.assignment3_noroff_janfeb.models.dto.character.CharacterDTO;
import com.example.assignment3_noroff_janfeb.models.dto.franchise.FranchiseDTO;
import com.example.assignment3_noroff_janfeb.models.dto.movies.MoviesDTO;
import com.example.assignment3_noroff_janfeb.services.franchise.FranchiseService;
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
@RequestMapping(path ="api/v1/franchise")
public class FranchiseController {
    private final FranchiseService franchiseService;
    private final FranchiseMapper franchiseMapper;
    private final MoviesService moviesService;
    private final MovieMapper movieMapper;

    private final CharacterMapper characterMapper;

    public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper, MoviesService moviesService, MovieMapper movieMapper, CharacterMapper characterMapper) {
        this.franchiseService = franchiseService;
        this.franchiseMapper = franchiseMapper;
        this.moviesService = moviesService;
        this.movieMapper = movieMapper;
        this.characterMapper = characterMapper;
    }

    @GetMapping
    @Operation(summary = "Get all the franchises")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema =@Schema(implementation = MoviesDTO.class)))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(mediaType = "application/json",
                            schema=@Schema(implementation = ProblemDetail.class))
            )
    })
    public ResponseEntity findAll(){
        return ResponseEntity.ok(franchiseMapper
                .franchiseToFranchiseDTO(
                        franchiseService.findAll()));
    }



    @GetMapping("{id}")
    @Operation(summary = "Get a single franchise")
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
        return ResponseEntity.ok(franchiseMapper
                .franchiseToFranchiseDTO(
                        franchiseService.findById(id)));

    }

    @PostMapping
    @Operation(summary = "Adds a new franchise")
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = @Content
            )
    })
    ResponseEntity add(@RequestBody FranchiseDTO entity){
        Franchise franchise = franchiseMapper.franchiseDTOToFranchise(entity);
        franchiseService.add(franchise);
        URI uri = URI.create("api/v1/franchise/" + franchise.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    @Operation(summary = "Updates a franchise")
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

    public ResponseEntity update(@RequestBody FranchiseDTO entity, @PathVariable int id){
        if(id!= entity.getId() || !franchiseService.exists(id))
            return ResponseEntity.badRequest().build();

        Franchise franchise = franchiseMapper.franchiseDTOToFranchise(entity);
        franchiseService.update(franchise);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletes a franchise")
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
        franchiseService.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

    @PutMapping("{id}/movies")
    @Operation(summary = "Updates movies in a franchise")
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
    public ResponseEntity updateMoviesInFranchise(@PathVariable int id, @RequestBody int[] movies){
        if(!franchiseService.exists(id))
            return ResponseEntity.badRequest().build();
        franchiseService.updateMoviesInAFranchise(movies, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}/allMovies")
    @Operation(summary = "Get all movies in a franchise")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema=@Schema(implementation = MoviesDTO.class)))
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
    public ResponseEntity findAllMoviesInAFranchise(@PathVariable int id) {
        return ResponseEntity.ok(
                movieMapper.moviesToMoviesDTO(
                        franchiseService.findAllMoviesInFranchise(id)
                )
        );
    }
    @GetMapping("{id}/allcharacters")
    @Operation(summary = "Get all characters in a franchise")
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
    public ResponseEntity findAllCharactersInFranchise(@PathVariable int id){
        return ResponseEntity.ok(
                characterMapper.characterToCharacterDTO(
                        franchiseService.findAllCharactersInFranchise(id)
                )
        );
    }
}
