package com.backend.backend.security.config;

import com.backend.backend.security.filters.TokenAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * 02.08.2017
 *Филтер преобразует токен в объект аутентификации и скармливает security.
 *Security сам вызывает провайдер, в котором у нас находится токен и проверка на валидность
 */
@ComponentScan("com.backend.backend")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //

    private final TokenAuthFilter tokenAuthFilter;

    private final AuthenticationProvider authenticationProvider;

    @Autowired
    public WebSecurityConfig(TokenAuthFilter tokenAuthFilter, AuthenticationProvider authenticationProvider) {
        this.tokenAuthFilter = tokenAuthFilter;
        this.authenticationProvider = authenticationProvider;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(tokenAuthFilter, BasicAuthenticationFilter.class)
                .antMatcher("/**")
                .authenticationProvider(authenticationProvider)
                .authorizeRequests()
                .antMatchers("/users/**").hasAuthority("USER")
                .antMatchers("/login").permitAll()
                .antMatchers("/registration").permitAll();
        http.csrf().disable();
    }
}
