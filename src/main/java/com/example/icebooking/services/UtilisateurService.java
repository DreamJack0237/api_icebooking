package com.example.icebooking.services;

import com.example.icebooking.TypeDeRole;
import com.example.icebooking.models.Role;
import com.example.icebooking.models.Utilisateur;
import com.example.icebooking.models.Validation;
import com.example.icebooking.repositories.UtilisateurRepositorie;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UtilisateurService implements UserDetailsService {

    private UtilisateurRepositorie utilisateurRepositorie;
    private ValidationService validationService;
    private BCryptPasswordEncoder passwordEncoder;

    // conditions de validation de l'email
    public void Inscription(Utilisateur utilisateur) {
        if (utilisateur.getEmail().indexOf("@") == -1) {
            throw new RuntimeException("Votre email est invalide");
        }
        if (utilisateur.getEmail().indexOf(".") == -2) {
            throw new RuntimeException("Votre email est invalide");
        }
        if (utilisateur.getPassword() == null) {
            throw new IllegalArgumentException("Le mot de passe ne peut pas être null");
        }else {


            // cryptage du mot de passe
            String MpssCrypt = this.passwordEncoder.encode(utilisateur.getPassword());
            utilisateur.setPassword(MpssCrypt);
        }
        Optional<Utilisateur> utilisateurOptional= this.utilisateurRepositorie.findByEmail(utilisateur.getEmail());
        if (utilisateurOptional.isPresent()){
            throw new RuntimeException("cet email est deja utiliser");
        }

        // gestion des rôles
        Role roleUtilisateur = new Role();
        roleUtilisateur.setTitre(TypeDeRole.Etudiant);
        utilisateur.setRole(roleUtilisateur);

        utilisateur = this.utilisateurRepositorie.save(utilisateur);
        this.validationService.enregistreValidation(utilisateur);
    }

    public void activation(Map<String, String> activation) {
        Validation validation= this.validationService.RecupereEnFonctionDuCode(activation.get("code"));
        if(Instant.now().isAfter(validation.getExpiration())){
            throw new RuntimeException("Votre code a expirer");
        }
       Utilisateur utilisateurActiver = this.utilisateurRepositorie.findById(validation.getUtilisateur().getId()).orElseThrow(()->new RuntimeException("utilisateur inconnu"));
        utilisateurActiver.setActif(true);
        this.utilisateurRepositorie.save(utilisateurActiver);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.utilisateurRepositorie
                .findByEmail(username)
                .orElseThrow(()->
                        new UsernameNotFoundException("cet utilisateur n'existe pas dans notre systeme"));
    }
}
