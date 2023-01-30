package com.example.assignment3_noroff_janfeb.repositories;

import com.example.assignment3_noroff_janfeb.models.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {
}
