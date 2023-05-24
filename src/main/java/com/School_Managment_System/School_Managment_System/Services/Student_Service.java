package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.Course;
import com.School_Managment_System.School_Managment_System.Models.Student;
import com.School_Managment_System.School_Managment_System.Models.Teacher;
import com.School_Managment_System.School_Managment_System.Repositories.Student_Repository;
import com.School_Managment_System.School_Managment_System.Repositories.Teacher_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Student_Service {
    @Autowired
    Student_Repository student_repository;
    public List<Student> getAllStudents() {

        return student_repository.findAll();
    }

    public Student getStudentById(Long id) {

        return student_repository.findById(id).get();
    }

    public void addStudent(Student student){

        student_repository.save(student);
    }

    public void deleteStudent(Long id) {
        student_repository.deleteById(id);
    }
}
