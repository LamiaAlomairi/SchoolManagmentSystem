package com.School_Managment_System.School_Managment_System.Response;

import com.School_Managment_System.School_Managment_System.Models.StudentCourse;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
@Data
@Builder
public class StudentCourseResponse {
    Long id;
    Double grade;

    public static StudentCourseResponse convertRequestToResponse(StudentCourse studentCourseRequest) {
        return StudentCourseResponse.builder()
                .id(studentCourseRequest.getId())
                .grade(studentCourseRequest.getGrade())
                .build();
    }

    public static List<StudentCourseResponse> convertRequestListToResponseList(List<StudentCourse> studentCourseRequest) {
        List<StudentCourseResponse> studentCourseResponseList = new ArrayList<>();
        if (!studentCourseRequest.isEmpty()) {
            for (StudentCourse studentCoursesRequest : studentCourseRequest) {
                studentCourseResponseList.add(convertRequestToResponse(studentCoursesRequest));
            }
        }
        return studentCourseResponseList;
    }
}
