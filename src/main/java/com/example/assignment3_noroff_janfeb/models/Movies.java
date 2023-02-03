package com.example.assignment3_noroff_janfeb.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Movie model as a Movie class
 *
 * The models give the blueprint for our database, with codefirst.
 * We have the Movies table and its connections to two other tables, Franchise and Character.
 */

@Entity
@Setter
@Getter
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100 , nullable = false)
    String title;
    @Column(length = 100)
    String genre;
    @Column
    @Min(value = 0)
    int releaseYear;
    @Column(length = 50)
    String director;
    @Column(length=100)
    String picture;
    @Column(length = 255)
    String trailer;
    @ManyToMany
    @JoinTable(
            name = "movies_characters",
            joinColumns = {@JoinColumn(name = "movies_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )
    private Set<Character> characters;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

}
