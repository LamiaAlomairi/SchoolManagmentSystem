package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.Course;
import com.School_Managment_System.School_Managment_System.Models.Student;
import com.School_Managment_System.School_Managment_System.Models.StudentCourse;
import com.School_Managment_System.School_Managment_System.Repositories.StudentCourseRepository;
import com.School_Managment_System.School_Managment_System.Request.StudentCourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseService {
    @Autowired
    StudentCourseRepository studentCourseRepository;

    public void addStudentCourse(StudentCourseRequest studentCourseRequest){
        StudentCourse studentCourse = StudentCourseRequest.convert(studentCourseRequest);
        studentCourseRepository.save(studentCourse);
    }

    public List<StudentCourse> getAllStudentCourses() {

        return studentCourseRepository.findAll();
    }

    public StudentCourse getStudentCourseById(Long id) {

        return studentCourseRepository.findById(id).get();
    }

    public void deleteStudentCourse(Long id) {

        studentCourseRepository.deleteById(id);
    }

    public StudentCourse updateStudentCourse(Long id, StudentCourse updateData){
        StudentCourse studentCourse = studentCourseRepository.findById(id).orElse(null);
        if (studentCourse != null) {
            studentCourse.setGrade(updateData.getGrade());
            studentCourse.setStudent(updateData.getStudent());
            studentCourse.setCourse(updateData.getCourse());
            studentCourse.setIsActive(updateData.getIsActive());
            studentCourse.setUpdatedDate(updateData.getUpdatedDate());

            return studentCourseRepository.save(studentCourse);
        }
        return null;
    }
}
