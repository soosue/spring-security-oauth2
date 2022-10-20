package com.justdo.oauth2.config.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.justdo.oauth2.user.domain.Role;

@EnableWebSecurity
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService) {
        this.customOAuth2UserService = customOAuth2UserService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .authorizeRequests()
                .antMatchers("/", "/loginpage").permitAll()
                .antMatchers("/board").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/loginpage")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService)
                .and()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/forbidden.html");

        return http.build();
    }
}
