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
@Table(name = "classRoom")
public class ClassRoom extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float size;
    private String classCode;

    @OneToMany(mappedBy = "classRoom")
    @JsonIgnore
    private List<Course> courses;
}
