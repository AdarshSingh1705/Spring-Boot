package com.adarsh.spring_data_jpa.repository;

import com.adarsh.spring_data_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository
        extends JpaRepository<Student, Long> {

    @Query(value = """
            select* from student
            where email = :email
            """, nativeQuery = true)
    Optional<Student> findByEmail(@Param("email") String email);

//    @Query(value = """
//            select* from student
//            where email = ?1 AND name = ?2
//            """, nativeQuery = true)
//    Optional<Student> findByEmail(String email, String name);
}
