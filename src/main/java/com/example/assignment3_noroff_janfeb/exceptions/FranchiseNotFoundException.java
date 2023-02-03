package com.example.assignment3_noroff_janfeb.exceptions;

public class FranchiseNotFoundException extends EntityNotFoundException{

    public FranchiseNotFoundException(int id) {
        super("Franchise does not exist with ID: " + id);
    }
}
