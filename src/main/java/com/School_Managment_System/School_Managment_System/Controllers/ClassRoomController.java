package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.ClassRoom;
import com.School_Managment_System.School_Managment_System.Request.ClassRoomRequest;
import com.School_Managment_System.School_Managment_System.Response.ClassRoomResponse;
import com.School_Managment_System.School_Managment_System.Services.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "classRoom")
public class ClassRoomController {
    @Autowired
    ClassRoomService classRoomService;
    @GetMapping(value = "getAll")
    public List<ClassRoom> getAllClassRooms() {

        return classRoomService.getAllClassRooms();
    }
    @GetMapping(value = "getById")
    public ClassRoom getClassRoomById(@RequestParam Long id) {

        return classRoomService.getClassRoomById(id);
    }

    @PostMapping(value = "add")
    public ClassRoomResponse addClassRoom(@RequestBody ClassRoomRequest classRoomRequest) {
        ClassRoom addClass = classRoomService.addClassRoom(classRoomRequest.convertToClassRoom());

        ClassRoomResponse response = new ClassRoomResponse(
                addClass.getId(),
                addClass.getName(),
                addClass.getSize(),
                addClass.getClassCode()
        );
        return response;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteClassRoom(@PathVariable long id){
        classRoomService.deleteClassRoom(id);
        return ResponseEntity.ok("Class room deleted successfully.");
    }

    @PutMapping("{id}")
    public ResponseEntity<ClassRoom> updateClassRoom(@PathVariable Long id, @RequestBody ClassRoom updateData){
        ClassRoom classRoom = classRoomService.updateClassRoom(id, updateData);
        if (classRoom != null) {
            return ResponseEntity.ok(classRoom);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
