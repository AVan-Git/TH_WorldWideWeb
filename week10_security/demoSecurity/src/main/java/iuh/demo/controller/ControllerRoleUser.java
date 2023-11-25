package iuh.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControllerRoleUser {

    @GetMapping("")
    public String showRoleUser(){
        return "i have role user";
    }
}
