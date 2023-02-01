package com.example.assignment3_noroff_janfeb.models.dto.franchise;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class franchiseDTO {
    private int id;
    private String description;
    private String name;
    private Set<Integer> movies;
}
