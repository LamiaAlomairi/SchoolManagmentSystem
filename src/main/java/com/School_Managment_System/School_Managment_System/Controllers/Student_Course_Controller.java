package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.Student_Course;
import com.School_Managment_System.School_Managment_System.Services.Student_Course_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "student_course")
public class Student_Course_Controller {
    @Autowired
    Student_Course_Service studentCourseService;

    @PostMapping(value = "add")
    public String addStudentCourse(@RequestBody Student_Course studentCourse){
        studentCourseService.addStudentCourse(studentCourse);
        return "Information added";
    }
}
