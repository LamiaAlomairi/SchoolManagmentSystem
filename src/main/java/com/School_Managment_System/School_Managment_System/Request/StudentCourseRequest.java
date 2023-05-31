package com.School_Managment_System.School_Managment_System.Request;

import com.School_Managment_System.School_Managment_System.Models.Course;
import com.School_Managment_System.School_Managment_System.Models.Student;
import com.School_Managment_System.School_Managment_System.Models.StudentCourse;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
public class StudentCourseRequest {
    Double grade;
    Student student;
    Course course;

    public static StudentCourse convert(StudentCourseRequest request) {
        Date nowDate = new Date();
        StudentCourse studentCourse = new StudentCourse();

        studentCourse.setGrade(request.getGrade());
        studentCourse.setIsActive(true);
        studentCourse.setCreatedDate(nowDate);
        studentCourse.setUpdatedDate(nowDate);
        return studentCourse;
    }

    public static List<StudentCourse> convert(List<StudentCourseRequest> requestList) {
        List<StudentCourse> studentCourses = new ArrayList<>();
        if (!requestList.isEmpty()) {
            for (StudentCourseRequest studentCourseRequest : requestList) {
                studentCourses.add(convert(studentCourseRequest));
            }
        }
        return studentCourses;
    }
}
