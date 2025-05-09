package com.org.ags.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurity {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/public/**").permitAll()  // Allow /public/** without authentication
                        .anyRequest().authenticated()               // Everything else needs auth
                )
                .httpBasic()
                .and()
                .csrf().disable();; // Use HTTP Basic Auth
        return http.build();
    }
}
