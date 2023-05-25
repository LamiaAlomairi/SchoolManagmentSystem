package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.Teacher;
import com.School_Managment_System.School_Managment_System.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Teacher_Service {
    @Autowired
    TeacherRepository teacherRepository;
    public List<Teacher> getAllTeachers() {

        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id) {

        return teacherRepository.findById(id).get();
    }

    public void addTeacher(Teacher teacher){

        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {

        teacherRepository.deleteById(id);
    }

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
