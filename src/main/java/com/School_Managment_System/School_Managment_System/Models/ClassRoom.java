package com.School_Managment_System.School_Managment_System.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

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
    private Float area;
    private String classCode;
}
