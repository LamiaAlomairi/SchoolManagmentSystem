package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.ClassRoom;
import com.School_Managment_System.School_Managment_System.Repositories.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService {
    @Autowired
    ClassRoomRepository classRoomRepository;
    public List<ClassRoom> getAllClassRooms() {

        return classRoomRepository.findAll();
    }

    public ClassRoom getClassRoomById(Long id) {

        return classRoomRepository.findById(id).get();
    }

    public void addClassRoom(ClassRoom classRoom){

        classRoomRepository.save(classRoom);
    }

    public void deleteClassRoom(Long id) {
        classRoomRepository.deleteById(id);
    }

    public ClassRoom updateClassRoom(Long id, ClassRoom updateData){
        ClassRoom classRoom = classRoomRepository.findById(id).orElse(null);
        if (classRoom != null) {
            classRoom.setName(updateData.getName());
            classRoom.setClassCode(updateData.getClassCode());
            classRoom.setSize(updateData.getSize());
            classRoom.setCourses(updateData.getCourses());

            return classRoomRepository.save(classRoom);
        }
        return null;
    }
}
