package com.example.assignment3_noroff_janfeb.models.dto.movies;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Our movies data transfer object, which we use to help encapsulates the data from and to the database.
 */
@Getter
@Setter
public class MoviesDTO {
    private int id;
    private String director;
    private String genre;
    private String picture;
    private int releaseYear;
    private String title;
    private String trailer;
    private int franchise;
    private Set<Integer> characters;
}
