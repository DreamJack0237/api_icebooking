package com.example.icebooking.config;

import com.example.icebooking.services.UserServiceimpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Service
@EnableWebSecurity
public class JwtFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = null;
        String username = null;
        boolean isTokenExpired = true;

        final String authorization = request.getHeader("Authorization");
        // Bearer
        // eyJhbGciOiJIUzI1NiJ9.eyJub20iOiJsZW8iLCJlbWFpbCI6Im5nb3VvbGVvbmVsNEBnbWFpbC5jb20ifQ.u64UboYHCSz5CwLDl2g0fpu1c4oxUOQeJvkUZyi0HsI'

        if (authorization != null && authorization.startsWith("Bearer ")) {
            token = authorization.substring(7);
        }
        if (!isTokenExpired && username != null &&
                SecurityContextHolder.getContext().getAuthentication() == null) {

        }
        filterChain.doFilter(request, response);
    }
}
