package com.example.icebooking.controllers;

import com.example.icebooking.Dto.AuthenticationDto;
import com.example.icebooking.config.JwtService;
import com.example.icebooking.models.Utilisateur;
import com.example.icebooking.services.UserServiceimpl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserControleur {
    private final UserServiceimpl userServiceImpl;
    private AuthenticationManager authenticationManager;

    // @PostMapping("inscriptionBiblio")
    // public void inscriptionBiblio(@RequestBody Utilisateur utilisateur) {
    // log.info("InscriptionBiblio");
    // this.userServiceImpl.InscriptionBiblio(utilisateur);
    // }

}