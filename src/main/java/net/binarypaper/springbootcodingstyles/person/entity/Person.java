package net.binarypaper.springbootcodingstyles.person.entity;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = {Views.List.class, Views.View.class})
    @JsonView({Views.List.class, Views.View.class})
    @Schema(description = "The unique id of the person", example = "1")
    private Long id;

    @NotNull(groups = {Views.Create.class, Views.List.class, Views.View.class})
    @Size(min = 3, max = 100, groups = {Views.Create.class, Views.List.class, Views.View.class})
    @JsonView({Views.Create.class, Views.List.class, Views.View.class})
    @Schema(description = "The name of the person", example = "John Smith")
    private String name;

    @NotNull(groups = {Views.Create.class, Views.View.class})
    @Size(min = 10, max = 500, groups = {Views.Create.class, Views.View.class})
    @JsonView({Views.Create.class, Views.View.class})
    @Schema(description = "A description of the person", example = "John Smith is a nice guy.")
    private String description;

    public interface Views {

        public interface Create {
        }

        public interface List {
        }

        public interface View {
        }
    }
}