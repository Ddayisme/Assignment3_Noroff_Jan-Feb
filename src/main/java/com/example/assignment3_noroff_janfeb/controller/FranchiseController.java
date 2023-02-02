package com.example.assignment3_noroff_janfeb.controller;

import com.example.assignment3_noroff_janfeb.mappers.FranchiseMapper;
import com.example.assignment3_noroff_janfeb.models.Franchise;
import com.example.assignment3_noroff_janfeb.models.dto.franchise.franchiseDTO;
import com.example.assignment3_noroff_janfeb.models.dto.movies.moviesDTO;
import com.example.assignment3_noroff_janfeb.services.franchise.FranchiseService;
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

    public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper) {
        this.franchiseService = franchiseService;
        this.franchiseMapper = franchiseMapper;
    }

    @GetMapping
    @Operation(summary = "Get all the franchises")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema =@Schema(implementation = moviesDTO.class)))
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
                                    schema = @Schema(implementation = moviesDTO.class))
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
    ResponseEntity add(@RequestBody franchiseDTO entity){
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

    public ResponseEntity update(@RequestBody franchiseDTO entity, @PathVariable int id){
        if(id!= entity.getId())
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
        franchiseService.updateMoviesInAFranchise(movies, id);
        return ResponseEntity.noContent().build();
    }
}
