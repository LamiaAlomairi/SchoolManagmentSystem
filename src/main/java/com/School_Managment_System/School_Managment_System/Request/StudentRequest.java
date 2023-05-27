package com.School_Managment_System.School_Managment_System.Request;

import com.School_Managment_System.School_Managment_System.Models.Student;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
public class StudentRequest {
    String name;
    Integer age;
    String email;
    String gender;

    public static Student convert(StudentRequest request) {
        Date nowDate = new Date();
        Student student = new Student();

        student.setName(request.getName());
        student.setAge(request.getAge());
        student.setEmail(request.getEmail());
        student.setGender(request.getGender());
        student.setIsActive(true);
        student.setCreatedDate(nowDate);
        student.setUpdatedDate(nowDate);
        return student;
    }

    public static List<Student> convert(List<StudentRequest> requestList) {
        List<Student> students = new ArrayList<>();
        if (!requestList.isEmpty()) {
            for (StudentRequest studentRequests : requestList) {
                students.add(convert(studentRequests));
            }
        }
        return students;
    }
}
