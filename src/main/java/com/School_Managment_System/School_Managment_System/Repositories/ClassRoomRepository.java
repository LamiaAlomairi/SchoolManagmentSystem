package com.School_Managment_System.School_Managment_System.Repositories;

import com.School_Managment_System.School_Managment_System.Models.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {
    @Query(value = "select cr from ClassRoom cr")
    List<ClassRoom> getAllClassRooms();

    @Query(value = "select cr from ClassRoom cr where cr.id = :classRoomId")
    ClassRoom getClassRoomById(@Param("classRoomId") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ClassRoom cr SET cr.isActive = false WHERE cr.id = :classRoomId")
    void deleteClassRoomById(@Param("classRoomId") Long id);
}
