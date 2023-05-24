package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.School_Class;
import com.School_Managment_System.School_Managment_System.Models.Student;
import com.School_Managment_System.School_Managment_System.Repositories.School_Class_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class School_Class_Service {
    @Autowired
    School_Class_Repository school_class_repository;
    public List<School_Class> getAllSchool_Classes() {

        return school_class_repository.findAll();
    }

    public School_Class getSchool_ClassById(Long id) {

        return school_class_repository.findById(id).get();
    }

    public void addSchool_Class(School_Class school_class){

        school_class_repository.save(school_class);
    }

    public void deleteClassRoom(Long id) {
        school_class_repository.deleteById(id);
    }

    public School_Class updateClassRoom(Long id, School_Class updateData){

    }
}
