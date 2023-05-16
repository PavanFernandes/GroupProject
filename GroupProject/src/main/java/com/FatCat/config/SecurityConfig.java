package com.FatCat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("select username, password, enabled from user" +
                " where username=?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select username, role from user" +
                " where username=?");

        return jdbcUserDetailsManager;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configure -> configure
                        .requestMatchers("/signup").permitAll()
                        .requestMatchers("/register/processRegistrationForm").permitAll()
                        .requestMatchers("/").hasRole("STUDENT")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.loginPage("/welcome")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }
}

