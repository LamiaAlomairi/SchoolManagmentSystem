package com.School_Managment_System.School_Managment_System.Request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
public class ClassRoomRequest {
    private String name;
    private Float size;
    private String classCode;

    public ClassRoomRequest(String name, Float size, String classCode){
        this.name = name;
        this.size = size;
        this.classCode = classCode;
    }
}
