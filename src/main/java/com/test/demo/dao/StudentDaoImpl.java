package com.test.demo.dao;

import com.test.demo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Slf4j
public class StudentDaoImpl implements StudentDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    public Student edit(Student student) {
        entityManager.merge(student);
        return student;
    }

    @Override
    public void delete(Long id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    public Optional<Student> getById(Long id) {
        log.info("0");
        return Optional.ofNullable(entityManager.find(Student.class, id));
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Student> getAllStudents() {
        return entityManager.createQuery("""
            select students
            from Student as students
        """).getResultList();
    }
}
