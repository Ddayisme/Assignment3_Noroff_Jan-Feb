package com.example.assignment3_noroff_janfeb.models;

import jakarta.persistence.*;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 60 )
    String full_Name;

    @Column()
    String alias;

    @Column
    String gender;

    @Column
    String picture;
}
