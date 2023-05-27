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
public class Student extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Integer age;
    String email;
    String gender;


    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<StudentCourse> studentCourses;
}
