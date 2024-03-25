package com.example.icebooking.services;

import java.util.List;
import java.util.Optional;

// import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.icebooking.models.Utilisateur;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceimpl implements UserService {

    @Override
    public void getUserLectures(Integer userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method'getUserLectures'");
    }

    @Override
    public void getUserComments(Integer userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method'getUserComments'");
    }

    @Override
    public void getUserDownloadings(Integer userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method'getUserDownloadings'");
    }

    @Override
    public List<Utilisateur> getUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsers'");
    }

    @Override
    public List<Utilisateur> getActivatedUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActivatedUsers'");
    }

    // public void InscriptionBiblio(Utilisateur utilisateur) {
    // if (utilisateur.getEmail().indexOf("@") == -1) {
    // throw new RuntimeException("Votre email est invalide");
    // }
    // if (utilisateur.getEmail().indexOf(".") == -2) {
    // throw new RuntimeException("Votre email est invalide");

    // }
    // if (utilisateur.getPassword() == null) {
    // throw new IllegalArgumentException("Le mot de passe ne peut pas être null");
    // } else {

    // // cryptage du mot de passe
    // String MpssCrypt =
    // this.bCryptPasswordEncoder.encode(utilisateur.getPassword());
    // utilisateur.setPassword(MpssCrypt);
    // }
    // Optional<Utilisateur> utilisateurOptional =
    // this.utilisateurRepositorie.findByEmail(utilisateur.getEmail());
    // if (utilisateurOptional.isPresent()) {
    // throw new RuntimeException("cet email est deja utiliser");
    // }

    // // gestion des rôles
    // Role roleUtilisateur = new Role();
    // roleUtilisateur.setTitre(TypeDeRole.Bibliothequaire);
    // utilisateur.setRole(roleUtilisateur);

    // utilisateur = this.utilisateurRepositorie.save(utilisateur);
    // this.validationService.enregistreValidation(utilisateur);
    // }

}
