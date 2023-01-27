package com.example.assignment3_noroff_janfeb.models;

import jakarta.persistence.*;

@Entity
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100 , nullable = false)
    String title;

    @Column(length = 100)
    String genre;


    @Column()
    int realeseYear;

    @Column(length = 50)
    String director;

    @Column(length=100)
    String picture;

    @Column
    String trailer;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
