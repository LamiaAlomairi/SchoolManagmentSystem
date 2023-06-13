package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.ClassRoom;
import com.School_Managment_System.School_Managment_System.Models.Course;
import com.School_Managment_System.School_Managment_System.Repositories.ClassRoomRepository;
import com.School_Managment_System.School_Managment_System.Repositories.CourseRepository;
import com.School_Managment_System.School_Managment_System.Request.CourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ClassRoomRepository classRoomRepository;

//**** ***   Add New Course Data   *** *****
    public void addCourse(CourseRequest courseRequest){
        Course course = CourseRequest.convert(courseRequest);
        ClassRoom classRoom = classRoomRepository.getClassRoomById(courseRequest.getClassRoom().getId());
        course.setClassRoom(classRoom);
        courseRepository.save(course);
    }

//**** ***   Get All Course Data   *** *****
    public List<Course> getAllCourses() {
         return courseRepository.getAllCourses();
    }

//**** ***   Get Course Data By id   *** *****
    public Course getCourseById(Long id) {

        return courseRepository.getCourseById(id);
    }

//**** ***   Delete Course Data By id   *** *****
    public void deleteCourse(Long id) {

        courseRepository.deleteById(id);
    }

//**** ***   Update Course Data By id   *** *****
    public void updateCourse(Long id, CourseRequest courseRequest){
        Course course = courseRepository.getCourseById(id);
        if (course != null) {
            course.setName(courseRequest.getName());
            course.setCourseCode(courseRequest.getCourseCode());
            course.setDescription(courseRequest.getDescription());
            course.setClassRoom(courseRequest.getClassRoom());
            courseRepository.save(course);
        }
    }
}
