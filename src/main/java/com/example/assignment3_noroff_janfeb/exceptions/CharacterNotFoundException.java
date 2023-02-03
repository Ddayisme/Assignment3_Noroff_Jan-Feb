package com.example.assignment3_noroff_janfeb.exceptions;

public class CharacterNotFoundException extends EntityNotFoundException{
    public CharacterNotFoundException(int id) {
        super("Character does not exist with ID: " + id);
    }
}
