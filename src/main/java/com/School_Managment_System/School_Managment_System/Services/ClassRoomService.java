package com.School_Managment_System.School_Managment_System.Services;

import com.School_Managment_System.School_Managment_System.Models.ClassRoom;
import com.School_Managment_System.School_Managment_System.Repositories.ClassRoomRepository;
import com.School_Managment_System.School_Managment_System.Request.ClassRoomRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ClassRoomService {
    @Autowired
    ClassRoomRepository classRoomRepository;

//****    Create New Class Room Data    *****
    public void addClassRoom(ClassRoomRequest classRoomRequest) {
        ClassRoom classRoom = ClassRoomRequest.convert(classRoomRequest);
        classRoomRepository.save(classRoom);
    }

//****    Get All Data Of Class Room    *****
    public List<ClassRoom> getAllClassRooms() {
         return classRoomRepository.getAllClassRooms();
    }

//****    Get Data By id Of Class Room    *****
    public ClassRoom getClassRoomById(Long id) {

        return classRoomRepository.getClassRoomById(id);
    }

    //****    Delete Class Room Data By Id   *****
    public void deleteClassRoom(Long id) {

        classRoomRepository.deleteById(id);
    }

//****    Update Class Room Data    *****
    public ClassRoom updateClassRoom(Long id, ClassRoom updateData){
        ClassRoom classRoom = classRoomRepository.findById(id).orElse(null);
        if (classRoom != null) {
            classRoom.setName(updateData.getName());
            classRoom.setClassCode(updateData.getClassCode());
            classRoom.setArea(updateData.getArea());
//            classRoom.setCourses(updateData.getCourses());

            return classRoomRepository.save(classRoom);
        }
        return null;
    }
}
