package com.backend.backend.services;


import com.backend.backend.forms.LoginForm;
import com.backend.backend.transfer.TokenDto;

public interface LoginService {
    TokenDto login(LoginForm loginForm);
}
