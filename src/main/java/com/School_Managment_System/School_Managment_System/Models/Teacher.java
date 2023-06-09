package com.School_Managment_System.School_Managment_System.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "teacher")
public class Teacher extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String phoneNumber;
    String specialization;
    Integer age;

    @OneToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    Course course;
}
