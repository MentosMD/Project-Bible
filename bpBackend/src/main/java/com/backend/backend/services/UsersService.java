package com.backend.backend.services;


import com.backend.backend.forms.UserForm;
import com.backend.backend.models.User;

import java.util.List;

public interface UsersService {
    void signUp(UserForm userForm);

    List<User> findAll();

    User findOne(Long userId);
}
