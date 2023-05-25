package com.School_Managment_System.School_Managment_System.Repositories;

import com.School_Managment_System.School_Managment_System.Models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
