package com.School_Managment_System.School_Managment_System.Repositories;

import com.School_Managment_System.School_Managment_System.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
