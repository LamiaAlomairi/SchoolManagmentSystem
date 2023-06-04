package com.School_Managment_System.School_Managment_System.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {
    @GetMapping(value = "test")
    @PreAuthorize("hasRole('USER')")
    public String test(){
        return "${spring.profiles.active}";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminOnly() {
        return "You are an admin!";
    }
}
