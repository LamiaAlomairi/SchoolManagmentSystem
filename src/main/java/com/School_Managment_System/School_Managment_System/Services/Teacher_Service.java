package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.Teacher;
import com.School_Managment_System.School_Managment_System.Repositories.Teacher_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Teacher updateTeacher(Long id, Teacher teacher){
        Optional<Teacher> update = teacher_repository.findById(id);

        if (update != null) {
            teacher.setName(teacher.getName());
            teacher.setAge(teacher.getAge());
            teacher.setMajor(teacher.getMajor());
            teacher.setGender(teacher.getGender());
            teacher.setPhone_number(teacher.getPhone_number());
            teacher.setCourses(teacher.getCourses());

            return teacher_repository.save(teacher);
        }
        return null;
    }
}
