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
@Table(name = "school_class")
public class School_Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Float size;
    String class_code;

    @OneToMany(mappedBy = "school_class")
    @JsonIgnore
    private List<Course> courses;
}
