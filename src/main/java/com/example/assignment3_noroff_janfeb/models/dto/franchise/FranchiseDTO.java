package com.example.assignment3_noroff_janfeb.models.dto.franchise;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Our franchise data transfer object, which we use to help encapsulates the data from and to the database.
 */
@Getter
@Setter
public class FranchiseDTO {
    private int id;
    private String description;
    private String name;
    private Set<Integer> movies;
}
