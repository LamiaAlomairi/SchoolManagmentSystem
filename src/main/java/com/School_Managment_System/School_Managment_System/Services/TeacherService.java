package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.Teacher;
import com.School_Managment_System.School_Managment_System.Repositories.TeacherRepository;
import com.School_Managment_System.School_Managment_System.Request.TeacherRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

//**** ***   Add New Teacher Data   *** *****
    public void addTeacher(TeacherRequest teacherRequest){
        Teacher teacher = TeacherRequest.convert(teacherRequest);
        teacherRepository.save(teacher);
    }

//**** ***   Get All Teacher Data   *** *****
    public List<Teacher> getAllTeachers() {

        return teacherRepository.findAll();
    }

//**** ***   Get Teacher Data By id   *** *****
    public Teacher getTeacherById(Long id) {

        return teacherRepository.findById(id).get();
    }

//**** ***   Delete Teacher Data By id   *** *****
    public void deleteTeacher(Long id) {

        teacherRepository.deleteById(id);
    }

//**** ***   Update Teacher Data By id   *** *****
    public Teacher updateTeacher(Long id, Teacher updateData){
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if (teacher != null) {
            teacher.setName(updateData.getName());
            teacher.setPhoneNumber(updateData.getPhoneNumber());
            teacher.setAge(updateData.getAge());
            teacher.setSpecialization(updateData.getSpecialization());

            return teacherRepository.save(teacher);
        }
        return null;
    }
}
