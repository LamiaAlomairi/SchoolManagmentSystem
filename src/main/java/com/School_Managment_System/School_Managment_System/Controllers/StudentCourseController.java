package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.StudentCourse;
import com.School_Managment_System.School_Managment_System.Request.StudentCourseRequest;
import com.School_Managment_System.School_Managment_System.Services.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "studentCourse")
public class StudentCourseController {
    @Autowired
    StudentCourseService studentCourseService;

    @PostMapping(value = "add")
    public void addStudentCourse(@RequestBody StudentCourseRequest studentCourseRequest){
        studentCourseService.addStudentCourse(studentCourseRequest);
    }

    @GetMapping(value = "getAll")
    public List<StudentCourse> getAllStudentCourses() {

        return studentCourseService.getAllStudentCourses();
    }
}
