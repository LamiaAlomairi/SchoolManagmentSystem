package com.School_Managment_System.School_Managment_System.Repositories;

import com.School_Managment_System.School_Managment_System.Models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query(value = "select t from Teacher t")
    List<Teacher> getAllTeachers();

    @Query(value = "select t from Teacher t where t.id = :id")
    Teacher getTeacherById(Long id);
}
