package com.example.assignment3_noroff_janfeb.models;

import jakarta.persistence.*;

@Entity
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 60)
    String name;

    @Column(length = 1000)
    String description;
}
