package com.adarsh.repository;

import com.adarsh.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/student_db";
    String username = "CodeBlooded";
    String password = "CodeBlooded";


    public void createStudent(Student student){


        String sql = """
                            INSERT INTO students(name, email, age)
                            VALUES(?, ?, ?)
                        """;

        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);

            ){

//            Statement statement = connection.createStatement();

            // This is Block Statement's ways. which is not that good it have alot of problem such as:
            // SQL Injection Risk ==> If userInput is "' OR '1'='1", the query becomes unsafe.
            // Performance Issues ==> Each time you run a query, the database has to parse and compile it again.
            // This slows things down for repeated queries
            //Harder to Maintain ==> Mixing SQL strings with Java code makes queries messy and error-prone.
//            String sql = """
//                        INSERT INTO students(name, email, age)
//                        VALUES ('%s', '%s', '%d')
//                        """.formatted(student.getName(),
//                                    student.getEmail(),
//                                    student.getAge());
//
//            int result = statement.executeUpdate(sql);


            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());

            int rowAffected  = preparedStatement.executeUpdate();

            if(rowAffected == 1){
                System.out.println("created  successfully");
            }else{
                System.out.println("Creation operation failed");
            }


        } catch (SQLException e){
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }

    public void updatedStudent(Student student, Long id){

        String sql = """
                     UPDATE students
                     SET name = ?,
                         email = ?,
                         age = ?
                     WHERE id = ?
                     """;
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);
            ){
                preparedStatement.setString(1, student.getName());
                preparedStatement.setString(2, student.getEmail());
                preparedStatement.setInt(3, student.getAge());
                preparedStatement.setLong(4, id);

                int rowAffected = preparedStatement.executeUpdate();

                if(rowAffected == 1){
                    System.out.println("updation operation successfully");
                }else{
                    System.out.println("updation operation failed");
                }

            } catch (SQLException e){
                System.out.println("Database connection failed");
                e.printStackTrace();
            }
    }

    public void deleteStudent(Long id){

        String sql = """
                        DELETE FROM students WHERE id = ?
                     """;

        try (
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ){

            preparedStatement.setLong(1, id);

            int result = preparedStatement.executeUpdate();

            if(result == 1){
                System.out.println("DELETION operation successfully");
            }else{
                System.out.println("DELETION operation failed");
            }

        } catch (SQLException e){
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }

    public void getStudentById(Long id){

        String sql = """ 
                        SELECT id, name, email, age FROM students WHERE id = ? 
                     """;
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ){
            preparedStatement.setLong(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    Student student = mapRow(resultSet);
                    System.out.println(student);
                }
            }
        } catch (SQLException e){
            System.out.println("Database connection failed");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void getStudent(){

        String sql = """ 
                        SELECT id, name, email, age FROM students 
                     """;
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ){
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Student> studentList = new ArrayList<>();
                while(resultSet.next()) {
                    Student student = mapRow(resultSet);
                    studentList.add(student);
                    System.out.println(student);
                }
            }
        } catch (SQLException e){
            System.out.println("Database connection failed");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void completeCRUD(){
        try {

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String sql = "SELECT id, name, email, age  FROM students where id = 5";

            boolean result =  statement.execute(sql );

            if(result){
                ResultSet resultSet = statement.getResultSet();
            }else{
                int rowAffected = statement.getUpdateCount();
            }

            connection.close();
        } catch (SQLException e){
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }

    private Student mapRow(ResultSet resultSet) throws Exception {
        Student student = new Student();

        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));

        return student;
    }

}
