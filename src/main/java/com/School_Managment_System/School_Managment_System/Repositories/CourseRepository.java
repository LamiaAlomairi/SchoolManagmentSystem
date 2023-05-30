package com.School_Managment_System.School_Managment_System.Repositories;

import com.School_Managment_System.School_Managment_System.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query(value = "select c from Course c")
    List<Course> getAllCourses();

    @Query(value = "select c from Course c where c.id = :id")
    Course getCourseById(Long id);
}
