package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.Class_room;
import com.School_Managment_System.School_Managment_System.Repositories.Class_room_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Class_room_Service {
    @Autowired
    Class_room_Repository classRoomRepository;
    public List<Class_room> getAllClass_rooms() {

        return classRoomRepository.findAll();
    }

    public Class_room getClass_roomById(Long id) {

        return classRoomRepository.findById(id).get();
    }

    public void addClass_room(Class_room class_room){

        classRoomRepository.save(class_room);
    }

    public void deleteClassRoom(Long id) {
        classRoomRepository.deleteById(id);
    }

    public Class_room updateClassRoom(Long id, Class_room updateData){
        Class_room classRoom = classRoomRepository.findById(id).orElse(null);
        if (classRoom != null) {
            classRoom.setName(updateData.getName());
            classRoom.setClass_code(updateData.getClass_code());
            classRoom.setSize(updateData.getSize());
            classRoom.setCourses(updateData.getCourses());

            return classRoomRepository.save(classRoom);
        }
        return null;
    }
}
