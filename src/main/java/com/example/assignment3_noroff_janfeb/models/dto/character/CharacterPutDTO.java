package com.example.assignment3_noroff_janfeb.models.dto.character;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CharacterPutDTO {
    private int id;
    private String alias;
    private String full_name;
    private String gender;
    private String picture;
}
