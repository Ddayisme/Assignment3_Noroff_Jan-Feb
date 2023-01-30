package com.example.assignment3_noroff_janfeb.repositories;

import com.example.assignment3_noroff_janfeb.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface MoviesRepository extends JpaRepository<Movies, Integer> {
    @Query("select s from Movies s where s.title like %?1%")
    Set<Movies> findAllByName(String title);
}
