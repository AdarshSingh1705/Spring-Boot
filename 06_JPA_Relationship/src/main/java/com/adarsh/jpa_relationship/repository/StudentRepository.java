package com.adarsh.jpa_relationship.repository;

import com.adarsh.jpa_relationship.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;


@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student) {
        entityManager.persist(student);
    }

    @EntityGraph(attributePaths = {"department", "profile"})
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

}