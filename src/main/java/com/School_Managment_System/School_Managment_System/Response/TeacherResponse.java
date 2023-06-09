package com.School_Managment_System.School_Managment_System.Response;

import com.School_Managment_System.School_Managment_System.Models.Course;
import com.School_Managment_System.School_Managment_System.Models.Teacher;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.*;

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
    Course course;

    public static TeacherResponse convertRequestToResponse(Teacher teacherRequest) {
        return TeacherResponse.builder()
                .id(teacherRequest.getId())
                .name(teacherRequest.getName())
                .phoneNumber(teacherRequest.getPhoneNumber())
                .specialization(teacherRequest.getSpecialization())
                .age(teacherRequest.getAge())
                .course(teacherRequest.getCourse())
                .build();
    }

    public static List<TeacherResponse> convertRequestListToResponseList(List<Teacher> teacherRequest) {
        List<TeacherResponse> teacherResponseList = new ArrayList<>();
        if (!teacherRequest.isEmpty()) {
            for (Teacher teachersRequest : teacherRequest) {
                teacherResponseList.add(convertRequestToResponse(teachersRequest));
            }
        }
        return teacherResponseList;
    }
}
