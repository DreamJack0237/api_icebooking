package com.example.icebooking.services;

import com.example.icebooking.models.Utilisateur;
import com.example.icebooking.models.Validation;
import com.example.icebooking.repositories.ValidationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Service
@AllArgsConstructor
public class ValidationService {

    private final ValidationRepository validationRepository;
    private final EmailService emailService;

    public void enregistreValidation(Utilisateur utilisateur){
        Validation validation = new Validation();
        validation.setUtilisateur(utilisateur);
        Instant creation = Instant.now();
        validation.setCreation(creation);
        Instant expiration = creation.plus(10, ChronoUnit.MINUTES);
        validation.setExpiration(expiration);

        Random random = new Random();
        int randomInt = random.nextInt(999999);
        String code = String.format("%06d", randomInt);
        validation.setCode(code);

        this.validationRepository.save(validation);
        this.emailService.EnvoyerMail(validation);
    }
    public Validation RecupereEnFonctionDuCode(String code){
       return this.validationRepository.findByCode(code).orElseThrow(()-> new RuntimeException("Votre code est valide"));
    }

}
