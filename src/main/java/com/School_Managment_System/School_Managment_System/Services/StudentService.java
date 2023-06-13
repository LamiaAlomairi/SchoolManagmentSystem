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

    //**** ***   Add New Student Data   *** *****
    public void addStudent(StudentRequest studentRequest){
        Student student = StudentRequest.convert(studentRequest);
        studentRepository.save(student);
    }

//**** ***   Get All Student Data   *** *****
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

//**** ***   Get Student Data By id   *** *****
    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

//**** ***   Delete Student Data By id   *** *****
    public void deleteStudentById(Long id) {
        studentRepository.deleteStudentById(id);
    }

//**** ***   Update Student Data By id   *** *****
    public void updateStudent(Long id, StudentRequest studentRequest){
        Student student = studentRepository.getStudentById(id);
        if (student != null) {
            student.setName(studentRequest.getName());
            student.setEmail(studentRequest.getEmail());
            student.setAge(studentRequest.getAge());
            student.setGender(studentRequest.getGender());
            studentRepository.save(student);
        }
    }
}
