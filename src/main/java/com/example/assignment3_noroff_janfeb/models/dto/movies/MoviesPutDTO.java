package com.example.assignment3_noroff_janfeb.models.dto.movies;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class MoviesPutDTO {
    private int id;
    private String director;
    private String genre;
    private String picture;
    private int releaseYear;
    private String title;
    private String trailer;

}
