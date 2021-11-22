package com.emirleroglu.backenddemo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.emirleroglu.backenddemo.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;



public class JWTAuthFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager manager;

    public JWTAuthFilter(AuthenticationManager manager) {

        this.manager = manager;
        setFilterProcessesUrl("/api");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            User temp = new ObjectMapper()
                    .readValue(request.getInputStream(), User.class);

            return manager.authenticate(new UsernamePasswordAuthenticationToken(
                            temp.getEmail(),
                            temp.getPassword(),
                            new ArrayList<>()
                    )

            );

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String token = JWT.create()
                .withSubject(((User) authResult.getPrincipal()).getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstans.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SecurityConstans.SECRET.getBytes()));

        String body = ((User) authResult.getPrincipal()).getEmail() + " " + token;

        response.getWriter().write(body);
        response.getWriter().flush();
    }
}
