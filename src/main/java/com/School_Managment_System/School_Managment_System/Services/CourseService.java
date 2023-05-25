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
            course.setName(updateData.getName());
            course.setCourseCode(updateData.getCourseCode());
            course.setDescription(updateData.getDescription());
            course.setStudentCourses(updateData.getStudentCourses());
            course.setClassRoom(updateData.getClassRoom());
            course.setTeachers(updateData.getTeachers());

            return courseRepository.save(course);
        }
        return null;
    }
}
