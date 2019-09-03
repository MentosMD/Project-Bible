package com.backend.backend.services;


import com.backend.backend.forms.ProfileForm;
import com.backend.backend.forms.UserForm;
import com.backend.backend.models.User;
import com.backend.backend.models.exeptions.UserNotFoundException;

import java.util.List;

public interface UsersService {
    void signUp(UserForm userForm);

    List<User> findAll();

    User getUser(long userId) throws UserNotFoundException;

    User updateUser(ProfileForm profileForm, long userId) throws UserNotFoundException;
}
