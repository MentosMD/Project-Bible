package com.backend.backend.services;

import com.backend.backend.repositories.TokensRepository;
import com.backend.backend.repositories.UsersRepository;
import com.backend.backend.forms.LoginForm;
import com.backend.backend.models.Token;
import com.backend.backend.models.User;
import com.backend.backend.transfer.TokenDto;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.backend.backend.transfer.TokenDto.from;


@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private TokensRepository tokensRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public TokenDto login(LoginForm loginForm) {
        Optional<User> userCandidate = usersRepository.findOneByLogin(loginForm.getLogin());

        if (userCandidate.isPresent()) {
            User user = userCandidate.get(); // user из БД

            //todo.. сравниваем если пароль который пришел в запросе равен тому что в БД то создаем токен и сохраняем в БД к привязанный к юзеру.
            if (passwordEncoder.matches(loginForm.getPassword(), user.getHashPassword())) {
                Token token = Token.builder()
                        .user(user)
                        .value(RandomStringUtils.random(10, true, true))
                        .build();

                tokensRepository.save(token);
                return from(token);
            }
        }
        throw new IllegalArgumentException("User not found");
    }
}
