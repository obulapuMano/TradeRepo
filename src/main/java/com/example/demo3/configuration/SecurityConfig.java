package com.example.demo3.configuration;

import com.example.demo3.service.UserInfoUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserInfoUserDetailsService userInfoUserDetailsService;

    public SecurityConfig (UserInfoUserDetailsService userInfoUserDetailsService) {
        this.userInfoUserDetailsService = userInfoUserDetailsService;
    }
@Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
       return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/user").permitAll()
                        .anyRequest().authenticated())
               .userDetailsService(userInfoUserDetailsService)
               .httpBasic(Customizer.withDefaults())
                .build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
