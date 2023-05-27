package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.Teacher;
import com.School_Managment_System.School_Managment_System.Request.TeacherRequest;
import com.School_Managment_System.School_Managment_System.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @GetMapping(value = "getAll")
    public List<Teacher> getAllTeachers() {

        return teacherService.getAllTeachers();
    }
    @GetMapping(value = "getById")
    public Teacher getTeacherById(@RequestParam Long id) {

        return teacherService.getTeacherById(id);
    }

    @PostMapping(value = "add")
    public void addTeacher(@RequestBody TeacherRequest teacherRequest){
        teacherService.addTeacher(teacherRequest);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable long id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok("Entity deleted successfully.");
    }

    @PutMapping("{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher updateData){
        Teacher teacher = teacherService.updateTeacher(id, updateData);
        if (teacher != null) {
            return ResponseEntity.ok(teacher);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
