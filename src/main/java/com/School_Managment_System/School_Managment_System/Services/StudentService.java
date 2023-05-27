package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.Student;
import com.School_Managment_System.School_Managment_System.Repositories.StudentRepository;
import com.School_Managment_System.School_Managment_System.Request.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {

        return studentRepository.findById(id).get();
    }

    public void addStudent(StudentRequest studentRequest){
        Student student = StudentRequest.convert(studentRequest);
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student updateData){
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setName(updateData.getName());
            student.setEmail(updateData.getEmail());
            student.setAge(updateData.getAge());
            student.setGender(updateData.getGender());
            student.setStudentCourses(updateData.getStudentCourses());

            return studentRepository.save(student);
        }
        return null;
    }
}
