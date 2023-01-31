package com.example.assignment3_noroff_janfeb.controller;

import com.example.assignment3_noroff_janfeb.mappers.FranchiseMapper;
import com.example.assignment3_noroff_janfeb.services.franchise.FranchiseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity findAll(){
        return ResponseEntity.ok(franchiseMapper
                .franchiseToFranchiseDTO(
                        franchiseService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        return ResponseEntity.ok(franchiseMapper
                .franchiseToFranchiseDTO(
                        franchiseService.findById(id)));

    }
}
