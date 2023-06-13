package com.School_Managment_System.School_Managment_System.Repositories;

import com.School_Managment_System.School_Managment_System.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select s from Student s")
    List<Student> getAllStudents();

    @Query(value = "select s from Student s where s.id = :studentId")
    Student getStudentById(@Param("studentId") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Student s SET s.isActive = false WHERE s.id = :studentId")
    void deleteStudentById(@Param("studentId") Long id);
}
