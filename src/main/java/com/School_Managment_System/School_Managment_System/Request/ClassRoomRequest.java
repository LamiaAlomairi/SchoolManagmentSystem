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

    public ClassRoom convertToClassRoom () {
        Date nowDate = new Date();
        ClassRoom classRoom = new ClassRoom();

        classRoom.setId(this.getId());
        classRoom.setName(this.getName());
        classRoom.setSize(this.getSize());
        classRoom.setClassCode(this.getClassCode());
//        classRoom.setIsActive(true);
//        classRoom.setCreatedDate(nowDate);
//        classRoom.setUpdatedDate(nowDate);
        return classRoom;
    }
}
