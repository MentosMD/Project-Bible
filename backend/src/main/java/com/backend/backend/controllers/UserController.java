package com.backend.backend.controllers;

import com.backend.backend.Repository.UserRepository;
import com.backend.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserRepository userRepo;

    @Autowired
    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    // Login in
    @PostMapping("/login")
    public String login_in(@Valid User user) {
        User userFromDb = userRepo.findByEmail(user.getEmail());

        if (userFromDb != null) {
            return userFromDb.getToken();
        } else
            return "User not exist";
    }

    // User create
    @PostMapping("/create")
    public String userCreate(@Valid User user) {
        User userFromDb = userRepo.findByEmail(user.getEmail());

        if (userFromDb != null){
            return "User exists!";
        }
        userRepo.save(user);

        return "Registration completed successfully";
    }

    // Delete user
    @PostMapping("/user/delete/{id}")
    public String userDelete(@Valid User user) {
        User userFromDb = userRepo.findByEmail(user.getEmail());

        if (userFromDb != null) userRepo.delete(userFromDb);

        return "Removal was successful";
    }
}
