package com.malitourist.api.Security.filtres;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

public class JwtAuthentificationFilter extends UsernamePasswordAuthenticationFilter {
    final private AuthenticationManager authenticationManager;
    public JwtAuthentificationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res){
        System.out.println("----------------- attemptAuthentication ---------------------");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    public void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication authResult) throws ServletException, IOException {
        System.out.println("----------------- attemptAuthentication ---------------------");
        User user = (User) authResult.getPrincipal();
        Algorithm algorithm = Algorithm.HMAC256("maiga");
        String jwtTokenAccess = JWT.create()
                .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis()+2*60*1000))
                                .withIssuer(req.getRequestURL().toString())
                                        .withClaim("roles", user.getAuthorities().stream().map(ga-> ga.getAuthority()).collect(Collectors.toList()))
                                                .sign(algorithm);
        res.setHeader("Autorisation", jwtTokenAccess);

        super.successfulAuthentication(req, res, chain, authResult);
    }

}
