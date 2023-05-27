package com.School_Managment_System.School_Managment_System.Request;

import com.School_Managment_System.School_Managment_System.Models.ClassRoom;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.*;
import javax.persistence.*;

@Getter
@Setter
@Data
public class ClassRoomRequest {
    private String name;
    private Float size;
    private String classCode;

//    public ClassRoom convertToClassRoom () {
//        Date nowDate = new Date();
//        ClassRoom classRoom = new ClassRoom();
//
//        classRoom.setName(this.getName());
//        classRoom.setSize(this.getSize());
//        classRoom.setClassCode(this.getClassCode());
//        classRoom.setIsActive(true);
//        classRoom.setCreatedDate(nowDate);
//        classRoom.setUpdatedDate(nowDate);
//        return classRoom;
//    }

    public static ClassRoom convert(ClassRoomRequest request) {
        Date nowDate = new Date();
        ClassRoom classRoom = new ClassRoom();

        classRoom.setName(request.getName());
        classRoom.setSize(request.getSize());
        classRoom.setClassCode(request.getClassCode());
        classRoom.setIsActive(true);
        classRoom.setCreatedDate(nowDate);
        classRoom.setUpdatedDate(nowDate);
        return classRoom;
    }

    public static List<ClassRoom> convert(List<ClassRoomRequest> requestList) {
        List<ClassRoom> classRooms = new ArrayList<>();
        if (!requestList.isEmpty()) {
            for (ClassRoomRequest classRequest : requestList) {
                classRooms.add(convert(classRequest));
            }
        }
        return classRooms;


    }
}
