package com.School_Managment_System.School_Managment_System.Repositories;

import com.School_Managment_System.School_Managment_System.Models.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;
@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
    @Query(value = "select sc from StudentCourse sc")
    List<StudentCourse> getAllStudentCourses();

    @Query(value = "select sc from StudentCourse sc where sc.id = :studentCourseId")
    StudentCourse getStudentCourseById(@Param("studentCourseId") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE StudentCourse sc SET sc.isActive = false WHERE sc.id = :studentCourseId")
    void deleteStudentCourseById(@Param("studentCourseId") Long id);
}
