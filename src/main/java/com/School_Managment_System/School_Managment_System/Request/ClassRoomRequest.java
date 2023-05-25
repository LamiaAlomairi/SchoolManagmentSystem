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
@Entity
public class ClassRoomRequest {
    private Long id;
    private String name;
    private Float size;
    private String classCode;

    public ClassRoomRequest(Long id, String name, Float size, String classCode){
        this.id = id;
        this.name = name;
        this.size = size;
        this.classCode = classCode;
    }
    public static ClassRoom convert(ClassRoomRequest request) {

        ClassRoom classRoom = new ClassRoom();
        Date nowDate = new Date();
        classRoom.setId(request.getId());
        classRoom.setName(request.getName());
        classRoom.setSize(request.getSize());
        classRoom.setClassCode(request.getClassCode());
        classRoom.setIsActive(true);
        classRoom.setCreatedDate(nowDate);
        classRoom.setUpdateDate(nowDate);
        return classRoom;
    }

    public static List<ClassRoom> convert(List<ClassRoomRequest> requestList) {
        List<ClassRoom> classRooms = new ArrayList<>();
        if (!requestList.isEmpty()) {
            for (ClassRoomRequest classRoomRequest : requestList) {
                classRooms.add(convert(classRoomRequest));
            }
        }
        return classRooms;


    }
}
