package com.School_Managment_System.School_Managment_System.Controllers;

import com.School_Managment_System.School_Managment_System.Models.ClassRoom;
import com.School_Managment_System.School_Managment_System.Request.ClassRoomRequest;
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

//****    Create New Class Room Data    *****
    @PostMapping(value = "add")
    public void addClassRoom(@RequestBody ClassRoomRequest classRoomRequest) {
        classRoomService.addClassRoom(classRoomRequest);
    }

//****    Get All Data Of Class Room    *****
    @GetMapping(value = "getAll")
    public List<ClassRoom> getAllClassRooms() {
        return classRoomService.getAllClassRooms();
    }

//****    Get Data By id Of Class Room    *****
    //http://localhost:8080/classRoom/getById?id=2
    @GetMapping(value = "getById")
    public ClassRoom getClassRoomById(@RequestParam Long id) {

        return classRoomService.getClassRoomById(id);
    }

//****    Delete Class Room Data By Id   *****
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteClassRoom(@PathVariable long id){
        classRoomService.deleteClassRoom(id);
        return ResponseEntity.ok("Class room deleted successfully.");
    }

//****    Update Class Room Data    *****
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
