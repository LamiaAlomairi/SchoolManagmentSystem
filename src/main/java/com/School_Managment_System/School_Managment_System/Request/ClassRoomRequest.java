package com.School_Managment_System.School_Managment_System.Request;

import com.School_Managment_System.School_Managment_System.Models.ClassRoom;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
@Data
public class ClassRoomRequest {
    private Long id;
    private String name;
    private Float area;
    private String classCode;

    public static ClassRoom convert(ClassRoomRequest request) {
        Date nowDate = new Date();
        ClassRoom classRoom = new ClassRoom();

        classRoom.setName(request.getName());
        classRoom.setArea(request.getArea());
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
