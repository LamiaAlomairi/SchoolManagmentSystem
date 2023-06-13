package com.School_Managment_System.School_Managment_System.Repositories;

import com.School_Managment_System.School_Managment_System.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query(value = "select c from Course c")
    List<Course> getAllCourses();

    @Query(value = "select c from Course c where c.id = :courseId")
    Course getCourseById(@Param("courseId") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Course c SET c.isActive = false WHERE c.id = :courseId")
    void deleteCourseById(@Param("courseId") Long id);
}
