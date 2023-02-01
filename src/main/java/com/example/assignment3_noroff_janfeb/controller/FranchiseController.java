package com.example.assignment3_noroff_janfeb.controller;

import com.example.assignment3_noroff_janfeb.mappers.FranchiseMapper;
import com.example.assignment3_noroff_janfeb.models.Franchise;
import com.example.assignment3_noroff_janfeb.models.dto.franchise.franchiseDTO;
import com.example.assignment3_noroff_janfeb.services.franchise.FranchiseService;
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

    @PostMapping ResponseEntity add(@RequestBody franchiseDTO entity){
        Franchise franchise = franchiseMapper.franchiseDTOToFranchise(entity);
        franchiseService.add(franchise);
        URI uri = URI.create("api/v1/franchise/" + franchise.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody franchiseDTO entity, @PathVariable int id){
        if(id!= entity.getId())
            return ResponseEntity.badRequest().build();

        Franchise franchise = franchiseMapper.franchiseDTOToFranchise(entity);
        franchiseService.update(franchise);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable int id){
        franchiseService.deleteById(id);
        return  ResponseEntity.noContent().build();
    }
    /*  @GetMapping("{id}")
    public boolean exists(@PathVariable int id){
        Franchise franchise= franchiseService.findById(id);
        if(movie!=null)
            return true;
        return false;
    }    */
}
