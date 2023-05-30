package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.Course;
import com.School_Managment_System.School_Managment_System.Request.CourseRequest;
import com.School_Managment_System.School_Managment_System.Response.CourseResponse;
import com.School_Managment_System.School_Managment_System.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public Course getCourseById(@RequestParam Long id) {

        return courseService.getCourseById(id);
    }

//**** ***   Delete Course Data By id   *** *****
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable long id){
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted successfully.");
    }

//**** ***   Update Course Data By id   *** *****
    @PutMapping("{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course updateData){
        Course course = courseService.updateCourse(id, updateData);
        if (course != null) {
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
