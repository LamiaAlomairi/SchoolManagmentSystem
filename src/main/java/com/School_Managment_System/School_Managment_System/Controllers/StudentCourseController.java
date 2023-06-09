package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.StudentCourse;
import com.School_Managment_System.School_Managment_System.Request.StudentCourseRequest;
import com.School_Managment_System.School_Managment_System.Response.StudentCourseResponse;
import com.School_Managment_System.School_Managment_System.Services.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

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
    public List<StudentCourseResponse> getAllStudentCourses() {
        List<StudentCourse> studentCourses = new ArrayList<>();
        studentCourses = studentCourseService.getAllStudentCourses();
        List<StudentCourseResponse> listOfConvertedStudentCourse = StudentCourseResponse.convertRequestListToResponseList(studentCourses);
        return listOfConvertedStudentCourse;
    }

//**** ***   Get Student Course Data By id   *** *****
    @GetMapping(value = "getById")
    public StudentCourseResponse getStudentCourseById(@RequestParam Long id) {
        StudentCourse studentCourseToBeConverted = studentCourseService.getStudentCourseById(id);
        StudentCourseResponse convertedStudentCourse = StudentCourseResponse.convertRequestToResponse(studentCourseToBeConverted);
        return convertedStudentCourse;
    }

//**** ***   Delete Student Course Data By id   *** *****
    @DeleteMapping("{id}")
    public String deleteStudentCourseById(@PathVariable long id){
        studentCourseService.deleteStudentCourseById(id);
        return "Student course deleted successfully.";
    }

//**** ***   Update Student Course Data By id   *** *****
    @PutMapping("{id}")
    public void updateStudentCourse(@PathVariable Long id, @RequestBody StudentCourseRequest studentCourseRequest){
        studentCourseService.updateStudentCourse(id, studentCourseRequest);
    }
}
