package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.Teacher;
import com.School_Managment_System.School_Managment_System.Repositories.Teacher_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Teacher_Service {
    @Autowired
    Teacher_Repository teacher_repository;
    public List<Teacher> getAllTeachers() {

        return teacher_repository.findAll();
    }

    public Teacher getTeacherById(Long id) {

        return teacher_repository.findById(id).get();
    }

    public void addTeacher(Teacher teacher){
        teacher_repository.save(teacher);
    }

    public void deleteTeacher(Long id) {
        teacher_repository.deleteById(id);
    }

    public Teacher updateTeacher(Long id, Teacher updateData){
        Teacher teacher = teacher_repository.findById(id).orElse(null);

        if (teacher != null) {
            teacher.setName(updateData.getName());
            teacher.setSeplaization(updateData.getSeplaization());
            teacher.setPhone_number(updateData.getPhone_number());

            return teacher_repository.save(teacher);
        }
        return null;
    }
}
