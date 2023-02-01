package com.example.assignment3_noroff_janfeb.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 60)
    String name;
    @Column(length = 200)
    String description;
    @OneToMany(mappedBy = "franchise")
    private Set<Movies> movies;
}
