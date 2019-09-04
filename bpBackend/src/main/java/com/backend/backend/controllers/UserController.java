package com.backend.backend.controllers;

import com.backend.backend.forms.ProfileForm;
import com.backend.backend.forms.UserForm;
import com.backend.backend.models.User;
import com.backend.backend.models.exeptions.UserNotFoundException;
import com.backend.backend.services.UsersService;
import com.backend.backend.transfer.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.backend.backend.transfer.UserDto.from;


@RestController
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private final UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/registration")
    public ResponseEntity<Object> addUser(@RequestBody UserForm userForm) {
        usersService.signUp(userForm);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return from(usersService.findAll());
    }

    @GetMapping("/users/{user-id}")
    public ResponseEntity<ProfileForm> getProfile(@PathVariable("user-id") long userId) {
        User user;
        try {
            user = usersService.getUser(userId);
        } catch (Exception e) {
            LOG.warn(e.getMessage());
            LOG.debug(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(ProfileForm.newInstanceFromUser(user));
        }

    @PutMapping(value = "/users/update/{id}", produces = "application/json")
    public ResponseEntity<ProfileForm> updateProfile(@Valid @RequestBody ProfileForm profileForm, @PathVariable long id) {
        User user;
        try {
            user = usersService.updateUser(profileForm, id);
        } catch (UserNotFoundException e) {
            LOG.warn(e.getMessage());
            LOG.debug(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(ProfileForm.newInstanceFromUser(user));

    }
}

// Test synchronization Trello with GitHub.
