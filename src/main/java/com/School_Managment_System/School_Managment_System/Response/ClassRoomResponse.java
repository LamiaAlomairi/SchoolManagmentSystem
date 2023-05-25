package com.School_Managment_System.School_Managment_System.Response;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ClassRoomResponse {
    private Long id;
    private String name;
    private Float size;
    private String classCode;

}
