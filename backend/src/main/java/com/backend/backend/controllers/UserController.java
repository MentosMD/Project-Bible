package com.backend.backend.controllers;

import com.backend.backend.Repository.UserRepository;
import com.backend.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    // Login in
    @GetMapping("/login")
    public String login_in() {
        return "Hello user";
    }

    // User create
    @PostMapping("/user/create")
    public String userCreate(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByEmail(user.getEmail());

        if (userFromDb != null){
            model.put("message", "User exists!");
            return "registration";
        }

        userRepo.save(user);

        return "redirect:/login";

    }

    // Delete user
    @PostMapping("/user/delete/{id}")
    public boolean userDelete(@PathVariable int id) {
        return true;
    }
}
