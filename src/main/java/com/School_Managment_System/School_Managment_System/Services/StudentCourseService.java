package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.StudentCourse;
import com.School_Managment_System.School_Managment_System.Repositories.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseService {
    @Autowired
    StudentCourseRepository studentCourseRepository;

    public void addStudentCourse(StudentCourse studentCourse){

        studentCourseRepository.save(studentCourse);
    }

    public List<StudentCourse> getAllStudentCourses() {

        return studentCourseRepository.findAll();
    }
}
