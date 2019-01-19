package com.backend.backend.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "*")
public class UserController {

    // Login in
    @GetMapping("/login")
    public String login_in() {
        return "Hello user";
    }

    // User create
    @PostMapping("/user/create")
    public boolean userCreate() {
        return true;
    }

    // Delete user
    @PostMapping("/user/delete/{id}")
    public boolean userDelete(@PathVariable int id) {
        return true;
    }
}
