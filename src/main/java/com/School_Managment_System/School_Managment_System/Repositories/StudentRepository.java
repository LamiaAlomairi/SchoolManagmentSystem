package com.School_Managment_System.School_Managment_System.Repositories;

import com.School_Managment_System.School_Managment_System.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select s from Student s")
    List<Student> getAllStudents();

    @Query(value = "select s from Student s where s.id = :id")
    Student getStudentById(Long id);
}
