package com.School_Managment_System.School_Managment_System.Response;

import com.School_Managment_System.School_Managment_System.Models.Teacher;
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
public class TeacherResponse {
    Long id;
    String name;
    String phoneNumber;
    String specialization;
    Integer age;

    public static TeacherResponse convertRequestToResponse(Teacher teacherRequest) {
        return TeacherResponse.builder()
                .id(teacherRequest.getId())
                .name(teacherRequest.getName())
                .phoneNumber(teacherRequest.getPhoneNumber())
                .specialization(teacherRequest.getSpecialization())
                .age(teacherRequest.getAge())
                .build();
    }

    public static List<TeacherResponse> convertRequestListToResponseList(List<Teacher> teacherRequest) {
        List<TeacherResponse> teacherResponseList = new ArrayList<>();
        if (!teacherRequest.isEmpty()) {
            for (Teacher Request : teacherRequest) {
                teacherResponseList.add(convertRequestToResponse(Request));
            }
        }
        return teacherResponseList;
    }
}
