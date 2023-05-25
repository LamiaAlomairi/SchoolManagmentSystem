package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.Course;
import com.School_Managment_System.School_Managment_System.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    public List<Course> getAllCourses() {

        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {

        return courseRepository.findById(id).get();
    }

    public void addCourse(Course course){

        courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public Course updateCourse(Long id, Course updateData){
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            course.setCourse_name(updateData.getCourse_name());
            course.setCourse_code(updateData.getCourse_code());
            course.setDescription(updateData.getDescription());
            course.setStudent_courses(updateData.getStudent_courses());
            course.setClass_room(updateData.getClass_room());

            return courseRepository.save(course);
        }
        return null;
    }
}
