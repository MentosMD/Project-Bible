package com.backend.backend.controllers;

import com.backend.backend.Repository.UserRepository;
import com.backend.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @PostMapping("/create")
    public Object userCreate(@Valid User user) {
        User userFromDb = userRepo.findByEmail(user.getEmail());

        if (userFromDb != null){
            return "not exist user";
        }
        userRepo.save(user);

        return "Registration completed successfully";
    }

    // Delete user
    @PostMapping("/user/delete/{id}")
    public boolean userDelete(@PathVariable int id) {
        return true;
    }
}
