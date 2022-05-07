package com.test.demo.service;

import com.test.demo.dao.StudentDao;
import com.test.demo.dto.StudentDto;
import com.test.demo.exception.NullStudentsInCollectionException;
import com.test.demo.exception.StudentNotFoundException;
import com.test.demo.mapper.StudentMapper;
import com.test.demo.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
public class StudentServiceImpl implements StudentService{

    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = StudentMapper.instance.fromDto(studentDto);
        student = studentDao.save(student);
        return StudentMapper.instance.toDto(student);
    }

    @Override
    public StudentDto edit(StudentDto studentDto) {
        Student student = StudentMapper.instance.fromDto(studentDto);
        student = studentDao.edit(student);
        return StudentMapper.instance.toDto(student);
    }

    @Override
    public void delete(Long id) {
        studentDao.delete(id);
    }

    @Override
    public StudentDto getById(Long id) {
        Student student = studentDao.getById(id).orElseThrow(() -> new StudentNotFoundException("Студент не найден"));
        return StudentMapper.instance.toDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = (List<Student>) studentDao.getAllStudents();
        if(students.isEmpty()){
            throw new NullStudentsInCollectionException("Нет студентов в листе");
        }
        List<StudentDto> studentsDto = new ArrayList<>();
        students.stream().map(StudentMapper.instance::toDto).forEach(studentsDto::add);
        return studentsDto;
    }


}
