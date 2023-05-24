package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.Student;
import com.School_Managment_System.School_Managment_System.Repositories.Student_Repository;
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

    public Student updateStudent(Long id, Student updateData){
        Student student = student_repository.findById(id).orElse(null);
        if (student != null) {
            student.setName(updateData.getName());
            student.setAge(updateData.getAge());
            student.setGender(updateData.getGender());
            student.setParents_number(updateData.getParents_number());
            student.setStudent_courses(updateData.getStudent_courses());

            return student_repository.save(student);
        }
        return null;
    }
}
