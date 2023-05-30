package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.Student;
import com.School_Managment_System.School_Managment_System.Request.StudentRequest;
import com.School_Managment_System.School_Managment_System.Response.StudentResponse;
import com.School_Managment_System.School_Managment_System.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    StudentService studentService;

//**** ***   Add New Student Data   *** *****
    @PostMapping(value = "add")
    public void addStudent(@RequestBody StudentRequest studentRequest){

        studentService.addStudent(studentRequest);
    }

//**** ***   Get All Student Data   *** *****
    @GetMapping(value = "getAll")
    public List<StudentResponse> getAllStudents() {
        List<Student> students = new ArrayList<>();
        students = studentService.getAllStudents();
        List<StudentResponse> listOfConvertedStudent =StudentResponse.convertRequestListToResponseList(students);
        return listOfConvertedStudent;
    }

//**** ***   Get Student Data By id   *** *****
    @GetMapping(value = "getById")
    public Student getStudentById(@RequestParam Long id) {

        return studentService.getStudentById(id);
    }

//**** ***   Delete Student Data By id   *** *****
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully.");
    }

//**** ***   Update Student Data By id   *** *****
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
