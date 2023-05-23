package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.Course;
import com.School_Managment_System.School_Managment_System.Models.Student;
import com.School_Managment_System.School_Managment_System.Repositories.Course_Repository;
import com.School_Managment_System.School_Managment_System.Repositories.Student_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Course_Service {
    @Autowired
    Course_Repository course_repository;
    public List<Course> getAllCourses() {

        return course_repository.findAll();
    }

    public Course getCourseById(Long id) {

        return course_repository.findById(id).get();
    }
}
