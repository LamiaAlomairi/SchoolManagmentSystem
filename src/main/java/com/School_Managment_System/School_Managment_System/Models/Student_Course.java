package com.School_Managment_System.School_Managment_System.Models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Student_Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
}
