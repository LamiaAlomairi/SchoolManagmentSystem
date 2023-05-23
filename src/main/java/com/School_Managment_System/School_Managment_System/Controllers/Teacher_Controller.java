package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.Teacher;
import com.School_Managment_System.School_Managment_System.Services.Teacher_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "teacher")
public class Teacher_Controller {
    @Autowired
    Teacher_Service teacher_service;
    @GetMapping(value = "getAll")
    public List<Teacher> getAllTeachers() {

        return teacher_service.getAllTeachers();
    }
    @GetMapping(value = "getById")
    public Teacher getTeacherById(@RequestParam Long id) {

        return teacher_service.getTeacherById(id);
    }
}
