package com.example.icebooking.services;

import com.example.icebooking.models.Validation;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void EnvoyerMail(Validation validation){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ngouoleonel3@gmain.com");
        message.setTo(validation.getUtilisateur().getEmail());
        message.setSubject("Code d'activation");

        String text = String.format("Bonjour %s, Votre code d'activation est %s. A bientôt!",
                validation.getUtilisateur().getNom(),
                validation.getCode()
        );
        message.setText(text);
        javaMailSender.send(message);
    }
}
