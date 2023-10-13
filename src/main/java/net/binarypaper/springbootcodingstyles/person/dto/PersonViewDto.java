package net.binarypaper.springbootcodingstyles.person.dto;

import lombok.Data;

@Data
public class PersonViewDto {
    
    private Long id;

    private String name;

    private String description;
}