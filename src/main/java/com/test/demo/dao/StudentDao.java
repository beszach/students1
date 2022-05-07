package com.test.demo.dao;

import com.test.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

public interface StudentDao {

    Student save(Student student);

    Student edit(Student student);

    void delete(Long id);

    Optional<Student> getById(Long id);

    Collection<Student> getAllStudents();

}
