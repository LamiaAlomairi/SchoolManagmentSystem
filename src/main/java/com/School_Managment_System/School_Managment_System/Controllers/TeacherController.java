package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.Teacher;
import com.School_Managment_System.School_Managment_System.Request.TeacherRequest;
import com.School_Managment_System.School_Managment_System.Response.TeacherResponse;
import com.School_Managment_System.School_Managment_System.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping(value = "teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

//**** ***   Add New Teacher Data   *** *****
    @PostMapping(value = "add")
    public void addTeacher(@RequestBody TeacherRequest teacherRequest){

        teacherService.addTeacher(teacherRequest);
    }

//**** ***   Get All Teacher Data   *** *****
    @GetMapping(value = "getAll")
    public List<TeacherResponse> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teachers = teacherService.getAllTeachers();
        List<TeacherResponse> listOfConvertedTeacher =TeacherResponse.convertRequestListToResponseList(teachers);
        return listOfConvertedTeacher;
    }

//**** ***   Get Teacher Data By id   *** *****
    @GetMapping(value = "getById")
    public TeacherResponse getTeacherById(@RequestParam Long id) {
        Teacher teacherToBeConverted = teacherService.getTeacherById(id);
        TeacherResponse convertedTeacher = TeacherResponse.convertRequestToResponse(teacherToBeConverted);
        return convertedTeacher;
    }

//**** ***   Delete Teacher Data By id   *** *****
    @DeleteMapping("{id}")
    public String deleteTeacherById(@PathVariable long id){
        teacherService.deleteTeacherById(id);
        return "Entity deleted successfully.";
    }

//**** ***   Update Teacher Data By id   *** *****
    @PutMapping("{id}")
    public void updateTeacher(@PathVariable Long id, @RequestBody TeacherRequest teacherRequest){
        teacherService.updateTeacher(id, teacherRequest);
    }
}
