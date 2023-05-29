package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.Course;
import com.School_Managment_System.School_Managment_System.Repositories.CourseRepository;
import com.School_Managment_System.School_Managment_System.Request.CourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

//**** ***   Add New Course Data   *** *****
    public void addCourse(CourseRequest courseRequest){
        Course course = CourseRequest.convert(courseRequest);
        courseRepository.save(course);
    }

//**** ***   Get All Course Data   *** *****
    public List<Course> getAllCourses() {

        return courseRepository.findAll();
    }

//**** ***   Get Course Data By id   *** *****
    public Course getCourseById(Long id) {

        return courseRepository.findById(id).get();
    }

//**** ***   Delete Course Data By id   *** *****
    public void deleteCourse(Long id) {

        courseRepository.deleteById(id);
    }

//**** ***   Update Course Data By id   *** *****
    public Course updateCourse(Long id, Course updateData){
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            course.setName(updateData.getName());
            course.setCourseCode(updateData.getCourseCode());
            course.setDescription(updateData.getDescription());
            course.setStudentCourses(updateData.getStudentCourses());
            course.setClassRoom(updateData.getClassRoom());

            return courseRepository.save(course);
        }
        return null;
    }
}
