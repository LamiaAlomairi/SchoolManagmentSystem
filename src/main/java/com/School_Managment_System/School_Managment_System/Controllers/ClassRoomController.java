package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.ClassRoom;
import com.School_Managment_System.School_Managment_System.Request.ClassRoomRequest;
import com.School_Managment_System.School_Managment_System.Response.ClassRoomResponse;
import com.School_Managment_System.School_Managment_System.Services.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping(value = "classRoom")
@Validated
public class ClassRoomController {
    @Autowired
    ClassRoomService classRoomService;

//****    Create New Class Room Data    *****
    @PostMapping(value = "add")
    @PreAuthorize("hasRole('ADMIN')") // Authorization: Only users with 'ADMIN' role can access
    public void addClassRoom(@RequestBody @Validated ClassRoomRequest classRoomRequest) {
            classRoomService.addClassRoom(classRoomRequest);
    }

//****    Get All Data Of Class Room    *****
    @GetMapping(value = "getAll")
    public List<ClassRoomResponse> getAllClassRooms() {
        List<ClassRoom> classRooms = classRoomService.getAllClassRooms();
        List<ClassRoomResponse> listOfConvertedClassRoom = ClassRoomResponse.convertRequestListToResponseList(classRooms);
        return listOfConvertedClassRoom;
    }

//****    Get Data By id Of Class Room    *****
    //http://localhost:8080/classRoom/getById?id=2
    @GetMapping(value = "getById")
    public ClassRoomResponse getClassRoomById(@RequestParam Long id) {
        ClassRoom classRoomToBeConverted = classRoomService.getClassRoomById(id);
        ClassRoomResponse convertedClassRoom = ClassRoomResponse.convertRequestToResponse(classRoomToBeConverted);
        return convertedClassRoom;
    }

//****    Delete Class Room Data By Id   *****
    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteClassRoom(@PathVariable long id){
        classRoomService.deleteClassRoom(id);
        return ResponseEntity.ok("Class room deleted successfully.");
    }

//****    Update Class Room Data    *****
    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateClassRoom(@PathVariable long id, @RequestBody @Validated ClassRoomRequest classRoomRequest) {
        classRoomService.updateClassRoom(id, classRoomRequest);
    }
}
