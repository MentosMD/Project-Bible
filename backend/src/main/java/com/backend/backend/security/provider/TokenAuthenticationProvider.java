package com.backend.backend.security.provider;


import com.backend.backend.models.Token;
import com.backend.backend.repositories.TokensRepository;
import com.backend.backend.security.token.TokenAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
    // Проверяем если токен, который приходит в запросе при логине существует, то делаем Его валидным и передаем к нему UserDetails
 **/
    @Component
    public class TokenAuthenticationProvider implements AuthenticationProvider{

        @Autowired
        private TokensRepository tokensRepository;

        @Autowired
        private UserDetailsService userDetailsService;

        @Override
        // К провайдеру приходит Authentication только тот что мы указали TokenAuthentication. Authentication = валидность.
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            TokenAuthentication tokenAuthentication = (TokenAuthentication)authentication; //TODO... Токен из запроса.
//
            Optional<Token> tokenCandidate = tokensRepository.findOneByValue(tokenAuthentication.getName()); // TODO... Токен из БД
//
            if (tokenCandidate.isPresent()) { //Todo... Если токен присутсвует в БД, то возвращаем валидный токен с User-ом
                UserDetails userDetails = userDetailsService.loadUserByUsername(tokenCandidate.get().getUser().getLogin()); //TODO... Получаем User-а через токен(они привзаны)
                tokenAuthentication.setUserDetails(userDetails); //TODO... Добавляем узера в TokenAuthentication
                tokenAuthentication.setAuthenticated(true); // TODO... Указываем токен как валидный
                return tokenAuthentication;
            } else throw new IllegalArgumentException("Bad token");
        }

        @Override
        public boolean supports(Class<?> authentication) { //TODO Сюда уазали наш класс TokenAuthentication. Провайдер будет ловить только его.
            return TokenAuthentication.class.equals(authentication);
        }
}
