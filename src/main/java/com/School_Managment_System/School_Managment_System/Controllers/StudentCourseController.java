package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.StudentCourse;
import com.School_Managment_System.School_Managment_System.Models.Teacher;
import com.School_Managment_System.School_Managment_System.Request.StudentCourseRequest;
import com.School_Managment_System.School_Managment_System.Services.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "studentCourse")
public class StudentCourseController {
    @Autowired
    StudentCourseService studentCourseService;

//**** ***   Add New Student Course Data   *** *****
    @PostMapping(value = "add")
    public void addStudentCourse(@RequestBody StudentCourseRequest studentCourseRequest){
        studentCourseService.addStudentCourse(studentCourseRequest);
    }

//**** ***   Get All Student Course Data   *** *****
    @GetMapping(value = "getAll")
    public List<StudentCourse> getAllStudentCourses() {

        return studentCourseService.getAllStudentCourses();
    }

//**** ***   Get Student Course Data By id   *** *****
    @GetMapping(value = "getById")
    public StudentCourse getStudentCourseById(@RequestParam Long id) {

        return studentCourseService.getStudentCourseById(id);
    }

//**** ***   Delete Student Course Data By id   *** *****
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudentCourse(@PathVariable long id){
        studentCourseService.deleteStudentCourse(id);
        return ResponseEntity.ok("Student course deleted successfully.");
    }
}
