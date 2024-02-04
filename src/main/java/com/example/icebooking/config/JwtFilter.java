package com.example.icebooking.config;

import com.example.icebooking.services.UtilisateurService;
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
@EnableWebSecurity
@Service
public class JwtFilter extends OncePerRequestFilter {
    private JwtService jwtService;

    private UtilisateurService utilisateurService;

    public JwtFilter(JwtService jwtService,UtilisateurService utilisateurService) {
        this.jwtService = jwtService;
        this.utilisateurService=utilisateurService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
String token=null;
String username=null;
        boolean isTokenExpired=true;

       final String authorization = request.getHeader("Authorization");
//        Bearer eyJhbGciOiJIUzI1NiJ9.eyJub20iOiJsZW8iLCJlbWFpbCI6Im5nb3VvbGVvbmVsNEBnbWFpbC5jb20ifQ.u64UboYHCSz5CwLDl2g0fpu1c4oxUOQeJvkUZyi0HsI' \
        if(authorization != null && authorization.startsWith("Bearer ")){
        token=authorization.substring(7);
        isTokenExpired= jwtService.isTokenExpired(token);
        username=this.jwtService.ExtractUsername(token);
        }
        if(!isTokenExpired && username !=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails= this.utilisateurService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authentication= new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request,response);
    }
}
