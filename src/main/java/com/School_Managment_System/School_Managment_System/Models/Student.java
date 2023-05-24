package com.School_Managment_System.School_Managment_System.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long student_id;
    String name;
    String email;
    String nationality;
    Date createdDate;
    Boolean isActive;
    Date updateDate;


    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Student_Course> student_courses;
}
