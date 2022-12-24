package com.malitourist.api.Security;

import com.malitourist.api.Security.filtres.JwtAuthentificationFilter;
import com.malitourist.api.modele.Utilisateur;
import com.malitourist.api.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
     private UtilisateurService utilisateurService;
//    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.headers().frameOptions().disable();
//        http.authorizeRequests().antMatchers("/login/**").permitAll();
//        http.formLogin().disable();
        http.authorizeRequests().anyRequest().permitAll();
        http.addFilter(new JwtAuthentificationFilter(authenticationManagerBean()));
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Utilisateur utilisateur = utilisateurService.recuperUtilisateur(username);

                    Collection<GrantedAuthority> authorities = new ArrayList<>();
                    utilisateur.getRoles().forEach(r -> {
                        authorities.add(new SimpleGrantedAuthority(r.getRole()));
                    });
                return new User(utilisateur.getUsername(), utilisateur.getPassword(), authorities);
            }
        });
    }
}
