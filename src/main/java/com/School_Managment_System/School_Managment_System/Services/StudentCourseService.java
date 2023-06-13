package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.Course;
import com.School_Managment_System.School_Managment_System.Models.Student;
import com.School_Managment_System.School_Managment_System.Models.StudentCourse;
import com.School_Managment_System.School_Managment_System.Repositories.CourseRepository;
import com.School_Managment_System.School_Managment_System.Repositories.StudentCourseRepository;
import com.School_Managment_System.School_Managment_System.Repositories.StudentRepository;
import com.School_Managment_System.School_Managment_System.Request.StudentCourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentCourseService {
    @Autowired
    StudentCourseRepository studentCourseRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;

//**** ***   Add New Student Course Data   *** *****
    public void addStudentCourse(StudentCourseRequest studentCourseRequest){
        StudentCourse studentCourse = StudentCourseRequest.convert(studentCourseRequest);
        Student student = studentRepository.getStudentById(studentCourseRequest.getStudent().getId());
        studentCourse.setStudent(student);
        Course course = courseRepository.getCourseById(studentCourseRequest.getCourse().getId());
        studentCourse.setCourse(course);
        studentCourseRepository.save(studentCourse);
    }

//**** ***   Get All Student Course Data   *** *****
    public List<StudentCourse> getAllStudentCourses() {

        return studentCourseRepository.getAllStudentCourses();
    }

//**** ***   Get Student Course Data By id   *** *****
    public StudentCourse getStudentCourseById(Long id) {

        return studentCourseRepository.getStudentCourseById(id);
    }

//**** ***   Delete Student Course Data By id   *** *****
    public void deleteStudentCourseById(Long id) {
        studentCourseRepository.deleteStudentCourseById(id);
    }

//**** ***   Update Student Course Data By id   *** *****
    public void updateStudentCourse(Long id, StudentCourseRequest studentCourseRequest){
        StudentCourse studentCourse = studentCourseRepository.getStudentCourseById(id);
        if (studentCourse != null) {
            studentCourse.setGrade(studentCourseRequest.getGrade());
            studentCourse.setStudent(studentCourseRequest.getStudent());
            studentCourse.setCourse(studentCourseRequest.getCourse());
            studentCourseRepository.save(studentCourse);
        }
    }
}
