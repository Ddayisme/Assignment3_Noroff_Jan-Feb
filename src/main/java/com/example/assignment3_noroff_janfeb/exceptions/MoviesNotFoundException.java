package com.example.assignment3_noroff_janfeb.exceptions;

public class MoviesNotFoundException extends EntityNotFoundException{
    public MoviesNotFoundException(int id) {
        super("Movie does not exist with ID: " + id);
    }
}
