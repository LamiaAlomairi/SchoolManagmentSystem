package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.Student;
import com.School_Managment_System.School_Managment_System.Request.StudentRequest;
import com.School_Managment_System.School_Managment_System.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping(value = "getAll")
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }
    @GetMapping(value = "getById")
    public Student getStudentById(@RequestParam Long id) {

        return studentService.getStudentById(id);
    }

    @PostMapping(value = "add")
    public void addStudent(@RequestBody StudentRequest studentRequest){
        studentService.addStudent(studentRequest);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully.");
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updateData){
        Student student = studentService.updateStudent(id, updateData);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
