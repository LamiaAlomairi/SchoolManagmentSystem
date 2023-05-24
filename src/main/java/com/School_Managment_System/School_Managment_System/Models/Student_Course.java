package com.School_Managment_System.School_Managment_System.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "student_course")
public class Student_Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    Course course;
}
