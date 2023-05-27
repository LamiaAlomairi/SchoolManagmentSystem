package com.School_Managment_System.School_Managment_System.Request;

import com.School_Managment_System.School_Managment_System.Models.Teacher;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
@Entity
public class TeacherRequest {
    String name;
    String phoneNumber;
    String specialization;
    Integer age;

    public static Teacher convert(TeacherRequest request) {
        Date nowDate = new Date();
        Teacher teacher = new Teacher();

        teacher.setName(request.getName());
        teacher.setPhoneNumber(request.getPhoneNumber());
        teacher.setSpecialization(request.getSpecialization());
        teacher.setAge(request.getAge());
        teacher.setIsActive(true);
        teacher.setCreatedDate(nowDate);
        teacher.setUpdatedDate(nowDate);
        return teacher;
    }

    public static List<Teacher> convert(List<TeacherRequest> requestList) {
        List<Teacher> teachers = new ArrayList<>();
        if (!requestList.isEmpty()) {
            for (TeacherRequest teacherRequest : requestList) {
                teachers.add(convert(teacherRequest));
            }
        }
        return teachers;
    }
}
