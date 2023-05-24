package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.Teacher;
import com.School_Managment_System.School_Managment_System.Repositories.Teacher_Repository;
import com.School_Managment_System.School_Managment_System.Services.Teacher_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(value = "add")
    public String addTeacher(@RequestBody Teacher teacher){
        teacher_service.addTeacher(teacher);
        return "Teacher added";
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable long id){
        teacher_service.deleteTeacher(id);
        return ResponseEntity.ok("Entity deleted successfully.");
    }

    @PutMapping("{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher updateData){
        Teacher teacher = teacher_service.updateTeacher(id, updateData);
        if (teacher != null) {
            return ResponseEntity.ok(teacher);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
