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
    String description;
    String course_code;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<Student_Course> student_courses;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    Class_room class_room;
}
