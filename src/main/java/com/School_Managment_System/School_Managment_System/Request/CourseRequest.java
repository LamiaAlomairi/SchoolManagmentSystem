package com.School_Managment_System.School_Managment_System.Request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
public class CourseRequest {
    String name;
    String description;
    String courseCode;
}
