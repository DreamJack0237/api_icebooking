package com.example.icebooking.controllers;


import com.example.icebooking.Dto.AuthenticationDto;
import com.example.icebooking.config.JwtService;
import com.example.icebooking.models.Utilisateur;
import com.example.icebooking.services.UtilisateurService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
public class UtilisateurControleur {
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;
    private UtilisateurService utilisateurService;
    @PostMapping("inscription")
    public void inscription(@RequestBody Utilisateur utilisateur){
        log.info("Inscription");
        this.utilisateurService.Inscription(utilisateur);

    }
    @PostMapping("inscriptionBiblio")
    public void inscriptionBiblio(@RequestBody Utilisateur utilisateur){
        log.info("InscriptionBiblio");
        this.utilisateurService.InscriptionBiblio(utilisateur);
    }
    @PostMapping("activation")
    public void activation(@RequestBody Map<String,String> activation){
        log.info("activation");
        this.utilisateurService.activation(activation);

    }
    @PostMapping(path =  "connexion")
    public Map<String,String > connexion(@RequestBody AuthenticationDto authenticationDto){
       final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationDto.username(), authenticationDto.password())

        );
       if(authentication.isAuthenticated()){
         return   this.jwtService.generate(authenticationDto.username());
       }
       log.info("Resultat {}", authentication.isAuthenticated());
        return null;

    }

}
