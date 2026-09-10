package com.adarsh;

import com.adarsh.repository.StudentRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();

//        studentRepository.createStudent(new Student("Rohan", "rohan@gmail.com", 20));
//        studentRepository.updatedStudent(new Student("Rohan Negi", "rohan@gmail.com", 25), 7L);
//        studentRepository.deleteStudent(7L);
//        studentRepository.getStudentById(2L);
        studentRepository.getStudent();
    }
}