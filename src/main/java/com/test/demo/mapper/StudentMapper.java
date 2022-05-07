package com.test.demo.mapper;

import com.test.demo.dto.StudentDto;
import com.test.demo.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper instance = Mappers.getMapper(StudentMapper.class);

//    default StudentDto toDto(Student student) {
//        return StudentDto.builder()
//                .id(42L)
//                .name(student.getName())
//                .courseNumber(student.getCourseNumber())
//                .description(student.getDescription())
//                .build();
//    }

    StudentDto toDto(Student student);

    Student fromDto(StudentDto studentDto);
}
