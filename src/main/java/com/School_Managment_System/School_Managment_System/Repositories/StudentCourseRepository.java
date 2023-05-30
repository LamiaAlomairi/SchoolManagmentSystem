package com.School_Managment_System.School_Managment_System.Repositories;

import com.School_Managment_System.School_Managment_System.Models.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
    @Query(value = "select sc from StudentCourse sc")
    List<StudentCourse> getAllStudentCourses();

    @Query(value = "select sc from StudentCourse sc where sc.id = :id")
    StudentCourse getStudentCourseById(Long id);
}
