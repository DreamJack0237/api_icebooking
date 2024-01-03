package com.example.icebooking.repositories;

import com.example.icebooking.models.Utilisateur;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UtilisateurRepositorie extends CrudRepository <Utilisateur,Integer> {
    Optional<Utilisateur> findByEmail(String email);
//    Optional<Utilisateur> findByNom(String email);

}
