package com.test.demo.rest;

import com.test.demo.dto.StudentDto;
import com.test.demo.mapper.StudentMapper;
import com.test.demo.model.Student;
import com.test.demo.service.StudentService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@Slf4j
public class StudentRestController {

    @Resource
    private final StudentService studentService;


    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Collection<StudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable(name = "id") long id){
        log.info("here");
        return studentService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto saveStudent(@RequestBody StudentDto studentDto){
        return studentService.save(studentDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StudentDto editStudent(@RequestBody StudentDto studentDto){
        return studentService.edit(studentDto);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable(name = "id") long id){
        studentService.delete(id);
        return "Студент отчислен!";
    }

    @GetMapping("/map")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto genStudentDto(){
        Student student = Student.builder()
                .id(26L)
                .courseNumber(3L)
                .name("zero")
                .description("map")
                .build();
        return StudentMapper.instance.toDto(student);
    }


}
