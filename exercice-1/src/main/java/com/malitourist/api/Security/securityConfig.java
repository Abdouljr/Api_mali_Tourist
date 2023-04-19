package com.malitourist.api.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class securityConfig {

// CETTE METHODE PERMET DE FILTRER LES REQUETTES EN FONCTION DE CRITERES
    @Bean
    public SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> auth
                .antMatchers("/test/protected").hasAnyRole("USER", "ADMIN")
                .antMatchers("/test/admin").hasRole("ADMIN")
                .antMatchers("/test/user").hasRole("USER")
                .antMatchers("/test/public").permitAll()
                .anyRequest()
                .authenticated())
                .httpBasic();
        return http.build();
    }


// CETTE METHODE UTILISE N'UTILISE PAS LA BD MAIS DIRECTEMENT DANS LES DONNEES CREER DANS LE CODE
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("user"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEncoder().encode("admin"))
            .roles("ADMIN")
            .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

// METHODE PERMET D'ENCODER LE MOT DE PASSE DE L'UTILISATEUR
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
