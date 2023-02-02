package com.example.assignment3_noroff_janfeb.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 60, nullable = false )
    private String full_name;
    @Column(length = 40)
    private String alias;
    @Column(length = 20)
    private String gender;
    @Column(length = 255)
    private String picture;
    @ManyToMany(mappedBy = "characters")
    private Set<Movies> movies;
}
