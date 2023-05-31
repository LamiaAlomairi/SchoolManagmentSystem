package com.School_Managment_System.School_Managment_System.Repositories;

import com.School_Managment_System.School_Managment_System.Models.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {
    @Query(value = "select cr from ClassRoom cr")
    List<ClassRoom> getAllClassRooms();

    @Query(value = "select cr from ClassRoom cr where cr.id = :classRoomId")
    ClassRoom getClassRoomById(@Param("classRoomId") Long id);
}
