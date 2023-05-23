package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.School_Class;
import com.School_Managment_System.School_Managment_System.Services.School_Class_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "school_class")
public class School_Class_Controller {
    @Autowired
    School_Class_Service school_class_service;
    @GetMapping(value = "getAll")
    public List<School_Class> getAllSchool_Classes() {

        return school_class_service.getAllSchool_Classes();
    }
    @GetMapping(value = "getById")
    public School_Class getSchool_ClassById(@RequestParam Long id) {

        return school_class_service.getSchool_ClassById(id);
    }

    @PostMapping(value = "add")
    public String addSchool_Class(@RequestBody School_Class school_class){
        school_class_service.addSchool_Class(school_class);
        return "Class added";
    }
}
