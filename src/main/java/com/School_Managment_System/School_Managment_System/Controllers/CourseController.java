package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.Course;
import com.School_Managment_System.School_Managment_System.Request.ClassRoomRequest;
import com.School_Managment_System.School_Managment_System.Request.CourseRequest;
import com.School_Managment_System.School_Managment_System.Response.CourseResponse;
import com.School_Managment_System.School_Managment_System.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping(value = "course")
public class CourseController {
    @Autowired
    CourseService courseService;

//**** ***   Add New Course Data   *** *****
    @PostMapping(value = "add")
    public void addCourse(@RequestBody CourseRequest courseRequest){
        courseService.addCourse(courseRequest);
    }

//**** ***   Get All Course Data   *** *****
    @GetMapping(value = "getAll")
    public List<CourseResponse> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        courses = courseService.getAllCourses();
        List<CourseResponse> listOfConvertedCourse = CourseResponse.convertRequestListToResponseList(courses);
        return listOfConvertedCourse;
    }

//**** ***   Get Course Data By id   *** *****
    @GetMapping(value = "getById")
    public CourseResponse getCourseById(@RequestParam Long id) {
        Course courseToBeConverted = courseService.getCourseById(id);
        CourseResponse convertedCourse = CourseResponse.convertRequestToResponse(courseToBeConverted);
        return convertedCourse;
    }

//**** ***   Delete Course Data By id   *** *****
    @DeleteMapping("{id}")
    public String deleteCourseById(@PathVariable long id){
        courseService.deleteCourseById(id);
        return "Course deleted successfully.";
    }

//**** ***   Update Course Data By id   *** *****
    @PutMapping("{id}")
    public void updateCourse(@PathVariable Long id, @RequestBody CourseRequest courseRequest){
        courseService.updateCourse(id, courseRequest);
    }
}
