package com.example.assignment3_noroff_janfeb.models.dto.character;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Our character data transfer object, which we use to help encapsulates the data from and to the database.
 */
@Getter
@Setter
public class CharacterDTO {
    private int id;
    private String alias;
    private String full_name;
    private String gender;
    private String picture;
    private Set<Integer> movies;
}
