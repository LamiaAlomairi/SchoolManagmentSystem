package com.School_Managment_System.School_Managment_System.Request;

import com.School_Managment_System.School_Managment_System.Models.ClassRoom;
import com.School_Managment_System.School_Managment_System.Models.Course;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.*;;

@Getter
@Setter
@Data
public class CourseRequest {
    String name;
    String description;
    String courseCode;
    ClassRoom classRoom;

    public static Course convert(CourseRequest request) {
        Date nowDate = new Date();
        Course course = new Course();

        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setCourseCode(request.getCourseCode());
        course.setIsActive(true);
        course.setCreatedDate(nowDate);
        course.setUpdatedDate(nowDate);
        return course;
    }

    public static List<Course> convert(List<CourseRequest> requestList) {
        List<Course> courses = new ArrayList<>();
        if (!requestList.isEmpty()) {
            for (CourseRequest courseRequest : requestList) {
                courses.add(convert(courseRequest));
            }
        }
        return courses;
    }
}
