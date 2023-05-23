package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.Course;
import com.School_Managment_System.School_Managment_System.Models.Student;
import com.School_Managment_System.School_Managment_System.Services.Course_Service;
import com.School_Managment_System.School_Managment_System.Services.Student_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "course")
public class Course_Controller {
    @Autowired
    Course_Service course_service;
    @GetMapping(value = "getAll")
    public List<Course> getAllCourses() {

        return course_service.getAllCourses();
    }
    @GetMapping(value = "getById")
    public Course getCourseById(@RequestParam Long id) {

        return course_service.getCourseById(id);
    }
}
