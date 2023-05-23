package com.School_Managment_System.School_Managment_System.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long course_id;
    String course_name;
    Float grade;
    String course_class;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<Student> students;

    @OneToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    Teacher teacher;

    @OneToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    School_Class school_class;
}
