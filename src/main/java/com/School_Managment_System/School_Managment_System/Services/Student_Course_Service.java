package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.Student_Course;
import com.School_Managment_System.School_Managment_System.Repositories.Student_Course_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Student_Course_Service {
    @Autowired
    Student_Course_Repository studentCourseRepository;

    public void addStudentCourse(Student_Course studentCourse){

        studentCourseRepository.save(studentCourse);
    }

    public List<Student_Course> getAllStudent_Courses() {

        return studentCourseRepository.findAll();
    }
}
