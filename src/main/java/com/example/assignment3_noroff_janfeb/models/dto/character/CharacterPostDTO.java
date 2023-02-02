package com.example.assignment3_noroff_janfeb.models.dto.character;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterPostDTO {
    private int id;
    private String alias;
    private String full_name;
    private String gender;
    private String picture;

}