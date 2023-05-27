package com.School_Managment_System.School_Managment_System.Response;

import com.School_Managment_System.School_Managment_System.Models.Student;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@Builder
public class StudentResponse {
    Long id;
    String name;
    Integer age;
    String email;
    String gender;

    public static StudentResponse convertRequestToResponse(Student studentRequest) {
        return StudentResponse.builder()
                .id(studentRequest.getId())
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .gender(studentRequest.getGender())
                .build();
    }

    public static List<StudentResponse> convertRequestListToResponseList(List<Student> studentRequest) {
        List<StudentResponse> studentResponseList = new ArrayList<>();
        if (!studentRequest.isEmpty()) {
            for (Student studentsRequest : studentRequest) {
                studentResponseList.add(convertRequestToResponse(studentsRequest));
            }
        }
        return studentResponseList;
    }
}
