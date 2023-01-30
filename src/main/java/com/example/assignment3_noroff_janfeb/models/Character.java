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

    @Column(length = 60 )
    private String full_Name;

    @Column()
    private String alias;

    @Column
    private String gender;

    @Column
    private String picture;

    @ManyToMany(mappedBy = "characters")

    private Set<Movies> movies;
}
