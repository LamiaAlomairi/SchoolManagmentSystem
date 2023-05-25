package com.School_Managment_System.School_Managment_System.Response;

import com.School_Managment_System.School_Managment_System.Models.ClassRoom;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.*;

@Getter
@Setter
@Data
@Entity
@Builder
public class ClassRoomResponse {
    private Long id;
    private String name;
    private Float size;
    private String classCode;
    public static ClassRoomResponse convertRequestToResponse(ClassRoom classRoomRequest) {
        return ClassRoomResponse.builder()
                .id(classRoomRequest.getId())
                .name(classRoomRequest.getName())
                .size(classRoomRequest.getSize())
                .classCode(classRoomRequest.getClassCode())
                .build();
    }

    public static List<ClassRoomResponse> convertRequestListToResponseList(List<ClassRoom> classRoomRequest) {
        List<ClassRoomResponse> customerResponseList = new ArrayList<>();
        if (!classRoomRequest.isEmpty()) {
            for (ClassRoom customerRequest : classRoomRequest) {
                customerResponseList.add(convertRequestToResponse(customerRequest));
            }
        }
        return customerResponseList;
    }
}
