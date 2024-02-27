// package com.example.icebooking.controllers;

// import java.util.Map;

// import org.springframework.http.MediaType;
// import org.springframework.security.authentication.AuthenticationManager;
// import
// org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.icebooking.Dto.AuthenticationDto;
// import com.example.icebooking.config.JwtService;
// import com.example.icebooking.models.Utilisateur;
// import com.example.icebooking.services.UserServiceimpl;

// import lombok.AllArgsConstructor;
// import lombok.extern.slf4j.Slf4j;

// @Slf4j
// @AllArgsConstructor
// @RestController
// @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
// public class UtilisateurControleur {
// private AuthenticationManager authenticationManager;
// private JwtService jwtService;
// private UserServiceimpl utilisateurService;

// @PostMapping("inscription")
// public void inscription(@RequestBody Utilisateur utilisateur) {
// log.info("Inscription");
// this.utilisateurService.Inscription(utilisateur);

// }

// @PostMapping("activation")
// public void activation(@RequestBody Map<String, String> activation) {
// log.info("activation");
// this.utilisateurService.activation(activation);

// }

// @PostMapping(path = "connexion")
// public Map<String, String> connexion(@RequestBody AuthenticationDto
// authenticationDto) {
// final Authentication authentication = authenticationManager.authenticate(
// new UsernamePasswordAuthenticationToken(authenticationDto.username(),
// authenticationDto.password())

// );
// if (authentication.isAuthenticated()) {
// return this.jwtService.generate(authenticationDto.username());
// }
// log.info("Resultat {}", authentication.isAuthenticated());
// return null;

// }

// }
