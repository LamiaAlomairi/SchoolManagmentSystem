package com.School_Managment_System.School_Managment_System.Repositories;

import com.School_Managment_System.School_Managment_System.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
