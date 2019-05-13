package com.backend.backend.controllers;

import com.backend.backend.forms.UserForm;
import com.backend.backend.models.User;
import com.backend.backend.services.UsersService;
import com.backend.backend.transfer.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.backend.backend.transfer.UserDto.from;


@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return from(usersService.findAll());
    }

    @GetMapping("/users/{user-id}")
    public User getUser(@PathVariable("user-id") Long userId) {
        return usersService.findOne(userId); // return JSon object user
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@RequestBody UserForm userForm) {
        usersService.signUp(userForm);
        return ResponseEntity.ok().build();
    }
}
