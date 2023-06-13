package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.Course;
import com.School_Managment_System.School_Managment_System.Models.Teacher;
import com.School_Managment_System.School_Managment_System.Repositories.CourseRepository;
import com.School_Managment_System.School_Managment_System.Repositories.TeacherRepository;
import com.School_Managment_System.School_Managment_System.Request.TeacherRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    CourseRepository courseRepository;

//**** ***   Add New Teacher Data   *** *****
    public void addTeacher(TeacherRequest teacherRequest){
        Teacher teacher = TeacherRequest.convert(teacherRequest);
        Course course = courseRepository.getCourseById(teacherRequest.getCourse().getId());
        teacher.setCourse(course);
        teacherRepository.save(teacher);
    }

//**** ***   Get All Teacher Data   *** *****
    public List<Teacher> getAllTeachers() {

        return teacherRepository.getAllTeachers();
    }

//**** ***   Get Teacher Data By id   *** *****
    public Teacher getTeacherById(Long id) {

        return teacherRepository.getTeacherById(id);
    }

//**** ***   Delete Teacher Data By id   *** *****
    public void deleteTeacher(Long id) {

        teacherRepository.deleteById(id);
    }

//**** ***   Update Teacher Data By id   *** *****
    public void updateTeacher(Long id, TeacherRequest teacherRequest){
        Teacher teacher = teacherRepository.getTeacherById(id);
        if (teacher != null) {
            teacher.setName(teacherRequest.getName());
            teacher.setPhoneNumber(teacherRequest.getPhoneNumber());
            teacher.setAge(teacherRequest.getAge());
            teacher.setSpecialization(teacherRequest.getSpecialization());
            teacherRepository.save(teacher);
        }
    }
}
