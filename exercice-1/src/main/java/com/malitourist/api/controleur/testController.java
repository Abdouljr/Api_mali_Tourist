package com.malitourist.api.controleur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testController {

    @GetMapping("/public")
    public String publicHello() {
        return "Hello World Public";
    }

    @GetMapping("/protected")
    public String protectedHello() {
        return "Hello World Protected";
    }
    @GetMapping("/user")
    public String userHello() {
        return "Hello World User";
    }
    @GetMapping("/admin")
    public String adminHello() {
        return "Hello World Admin";
    }
}
