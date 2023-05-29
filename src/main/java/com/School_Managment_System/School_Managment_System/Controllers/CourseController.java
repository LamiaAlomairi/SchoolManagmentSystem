package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.Course;
import com.School_Managment_System.School_Managment_System.Request.CourseRequest;
import com.School_Managment_System.School_Managment_System.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Course> getAllCourses() {

        return courseService.getAllCourses();
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
