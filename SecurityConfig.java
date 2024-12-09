package com.example.mypro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Password Encoder bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Password encoding using BCrypt
    }

    // Security Filter Chain to handle URL authorization and form login
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests() // Replaced deprecated 'authorizeRequests' with 'authorizeHttpRequests'
                .requestMatchers("/login", "/register").permitAll() // Allow access to login and register
                .anyRequest().authenticated() // Require authentication for other requests
            .and()
            .formLogin()
                .loginPage("/login") // Custom login page
                .permitAll() // Allow everyone to access the login page
            .and()
            .logout()
                .permitAll(); // Allow everyone to log out

        return http.build();
    }

    // Authentication Manager Builder for JDBC Authentication
    @Bean
    public AuthenticationManagerBuilder authenticationManagerBuilder(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

        // JDBC authentication configuration
        authenticationManagerBuilder.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
            .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?")
            .passwordEncoder(passwordEncoder()); // Use the BCrypt password encoder

        return authenticationManagerBuilder;
    }
}
