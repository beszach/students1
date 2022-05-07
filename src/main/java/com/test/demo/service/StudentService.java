package com.test.demo.service;

import com.test.demo.dto.StudentDto;
import com.test.demo.model.Student;

import java.util.Collection;

public interface StudentService {

    StudentDto save(StudentDto studentDto);

    StudentDto edit(StudentDto studentDto);

    void delete(Long id);

    StudentDto getById(Long id);

    Collection<StudentDto> getAllStudents();

}
