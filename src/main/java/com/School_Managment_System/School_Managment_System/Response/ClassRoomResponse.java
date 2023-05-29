package com.School_Managment_System.School_Managment_System.Response;

import com.School_Managment_System.School_Managment_System.Models.ClassRoom;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@Builder
public class ClassRoomResponse {
    private Long id;
    private String name;
    private Float size;
    private String classCode;

    public static ClassRoomResponse convertRequestToResponse(ClassRoom classRequest) {
        return ClassRoomResponse.builder()
                .id(classRequest.getId())
                .name(classRequest.getName())
                .size(classRequest.getSize())
                .classCode(classRequest.getClassCode())
                .build();
    }

    public static List<ClassRoomResponse> convertRequestListToResponseList(List<ClassRoom> classRequest) {
        List<ClassRoomResponse> classResponseList = new ArrayList<>();
        if (!classRequest.isEmpty()) {
            for (ClassRoom classRoomRequest : classRequest) {
                classResponseList.add(convertRequestToResponse(classRoomRequest));
            }
        }
        return classResponseList;
    }
}
