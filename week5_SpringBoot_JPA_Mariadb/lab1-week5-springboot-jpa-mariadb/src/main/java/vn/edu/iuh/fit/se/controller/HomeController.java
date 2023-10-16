package vn.edu.iuh.fit.se.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/home")
    public String myHome() {
        return "Hello (^-^)";
    }
}
