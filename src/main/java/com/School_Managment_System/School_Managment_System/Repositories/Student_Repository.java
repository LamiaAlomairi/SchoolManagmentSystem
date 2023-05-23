package com.School_Managment_System.School_Managment_System.Repositories;

import com.School_Managment_System.School_Managment_System.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Student_Repository extends JpaRepository<Student, Long> {
}
