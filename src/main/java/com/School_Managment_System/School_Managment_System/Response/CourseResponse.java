package com.School_Managment_System.School_Managment_System.Response;

import com.School_Managment_System.School_Managment_System.Models.ClassRoom;
import com.School_Managment_System.School_Managment_System.Models.Course;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
@Data
@Builder
public class CourseResponse {
    Long id;
    String name;
    String description;
    String courseCode;
    ClassRoom classRoom;

    public static CourseResponse convertRequestToResponse(Course courseRequest) {
        return CourseResponse.builder()
                .id(courseRequest.getId())
                .name(courseRequest.getName())
                .description(courseRequest.getDescription())
                .courseCode(courseRequest.getCourseCode())
                .classRoom(courseRequest.getClassRoom())
                .build();
    }

    public static List<CourseResponse> convertRequestListToResponseList(List<Course> courseRequest) {
        List<CourseResponse> courseResponseList = new ArrayList<>();
        if (!courseRequest.isEmpty()) {
            for (Course coursesRequest : courseRequest) {
                courseResponseList.add(convertRequestToResponse(coursesRequest));
            }
        }
        return courseResponseList;
    }
}
