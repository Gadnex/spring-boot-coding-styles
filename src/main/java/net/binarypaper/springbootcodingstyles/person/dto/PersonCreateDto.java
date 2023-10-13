package net.binarypaper.springbootcodingstyles.person.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PersonCreateDto {
    
    @NotNull
    @Size(min = 3, max = 100)
    @Schema(description = "The name of the person", example = "John Smith")
    private String name;

    @NotNull
    @Size(min = 10, max = 500)
    @Schema(description = "A description of the person", example = "John Smith is a nice guy.")
    private String description;
}