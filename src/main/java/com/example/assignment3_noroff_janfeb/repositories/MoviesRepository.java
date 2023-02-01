package com.example.assignment3_noroff_janfeb.repositories;

import com.example.assignment3_noroff_janfeb.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Movies, Integer> {
}
