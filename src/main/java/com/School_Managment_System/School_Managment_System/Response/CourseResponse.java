package com.School_Managment_System.School_Managment_System.Response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Data
@Entity
public class CourseResponse {
    Long id;
    String name;
    String description;
    String courseCode;
}
