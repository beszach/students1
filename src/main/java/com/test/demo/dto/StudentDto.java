package com.test.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.demo.model.Student;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {

    private Long id;

    private String name;

    @JsonProperty(value = "course_number")
    private Long courseNumber;

    private String description;

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseNumber=" + courseNumber +
                ", description='" + description + '\'' +
                '}';
    }
}
