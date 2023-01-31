package com.example.assignment3_noroff_janfeb.repositories;

import com.example.assignment3_noroff_janfeb.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
