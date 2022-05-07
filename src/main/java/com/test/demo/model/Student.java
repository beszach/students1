package com.test.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(generator="student_seq")
    @SequenceGenerator(name="student_seq",sequenceName="student_seq", allocationSize=1, initialValue = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "course_number", nullable = false)
    @JsonProperty(value = "course_number")
    private Long courseNumber;

    @Column(columnDefinition = "text")
    private String description;

    @Override
    public int hashCode() {
        return (int) ((long) id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseNumber=" + courseNumber +
                ", description='" + description + '\'' +
                '}';
    }
}
