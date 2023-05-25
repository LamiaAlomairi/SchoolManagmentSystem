package com.School_Managment_System.School_Managment_System.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "studentCourse")
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double grade;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    Course course;
}
