package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.Course;
import com.School_Managment_System.School_Managment_System.Models.School_Class;
import com.School_Managment_System.School_Managment_System.Models.Student;
import com.School_Managment_System.School_Managment_System.Repositories.Course_Repository;
import com.School_Managment_System.School_Managment_System.Repositories.Student_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Course_Service {
    @Autowired
    Course_Repository course_repository;
    public List<Course> getAllCourses() {

        return course_repository.findAll();
    }

    public Course getCourseById(Long id) {

        return course_repository.findById(id).get();
    }

    public void addCourse(Course course){

        course_repository.save(course);
    }

    public void deleteCourse(Long id) {
        course_repository.deleteById(id);
    }

    public Course updateCourse(Long id, Course updateData){
        Course course = course_repository.findById(id).orElse(null);
        if (course != null) {
            course.setCourse_name(updateData.getCourse_name());
            course.setCourse_code(updateData.getCourse_code());
            course.setDescription(updateData.getDescription());
            course.setStudents(updateData.getStudents());
            course.setTeacher(updateData.getTeacher());
            course.setSchool_class(updateData.getSchool_class());

            return course_repository.save(course);
        }
        return null;
    }
}
