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
    public void deleteClassRoomById(Long id) {
        classRoomRepository.deleteClassRoomById(id);
    }

//****    Update Class Room Data    *****
    public void updateClassRoom(Long id, ClassRoomRequest classRoomRequest) {
        ClassRoom classRoom = classRoomRepository.getClassRoomById(id);
        if (classRoom != null) {
            classRoom.setName(classRoomRequest.getName());
            classRoom.setClassCode(classRoomRequest.getClassCode());
            classRoom.setArea(classRoomRequest.getArea());
            classRoom.setUpdatedDate(new Date());
            classRoomRepository.save(classRoom);
        }
    }
}
