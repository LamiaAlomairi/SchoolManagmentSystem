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
    @GetMapping(value = "getAll")
    public List<Course> getAllCourses() {

        return courseService.getAllCourses();
    }
    @GetMapping(value = "getById")
    public Course getCourseById(@RequestParam Long id) {

        return courseService.getCourseById(id);
    }

    @PostMapping(value = "add")
    public void addCourse(@RequestBody CourseRequest courseRequest){
        courseService.addCourse(courseRequest);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable long id){
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted successfully.");
    }

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
