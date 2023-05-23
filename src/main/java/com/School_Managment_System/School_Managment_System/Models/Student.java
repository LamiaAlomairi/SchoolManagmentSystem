package com.School_Managment_System.School_Managment_System.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    String gender;
    Integer age;
    String parents_number;
}
