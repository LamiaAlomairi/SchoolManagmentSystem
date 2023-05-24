package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.Class_room;
import com.School_Managment_System.School_Managment_System.Services.Class_room_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "school_class")
public class Class_room_Controller {
    @Autowired
    Class_room_Service classRoomService;
    @GetMapping(value = "getAll")
    public List<Class_room> getAllClass_rooms() {

        return classRoomService.getAllClass_rooms();
    }
    @GetMapping(value = "getById")
    public Class_room getClass_roomById(@RequestParam Long id) {

        return classRoomService.getClass_roomById(id);
    }

    @PostMapping(value = "add")
    public String addClass_room(@RequestBody Class_room class_room){
        classRoomService.addClass_room(class_room);
        return "Class added";
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteClassRoom(@PathVariable long id){
        classRoomService.deleteClassRoom(id);
        return ResponseEntity.ok("Class room deleted successfully.");
    }

    @PutMapping("{id}")
    public ResponseEntity<Class_room> updateClassRoom(@PathVariable Long id, @RequestBody Class_room updateData){
        Class_room classRoom = classRoomService.updateClassRoom(id, updateData);
        if (classRoom != null) {
            return ResponseEntity.ok(classRoom);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
