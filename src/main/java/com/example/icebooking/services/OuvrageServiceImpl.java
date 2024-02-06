package com.example.icebooking.services;

import com.example.icebooking.models.Ouvrage;
import com.example.icebooking.models.Utilisateur;
import com.example.icebooking.repositories.OuvrageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;



@AllArgsConstructor
@Service
public class OuvrageServiceImpl implements OuvrageService {

    @Autowired
    private final OuvrageRepository ouvrageRepository;


    @Override
    public void createOuvrage(Ouvrage ouvrage){
        Utilisateur utilisateur =(Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ouvrage.setUtilisateur(utilisateur);
        this.ouvrageRepository.save(ouvrage);
    }
    @Override
    public void deleteOuvrage(Integer id){
        this.ouvrageRepository.deleteById(id);
    }
    @Override
    public void updateOuvrage(Integer id,Ouvrage ouvrage){
        Ouvrage existingProduct= ouvrageRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found with id: " + id));
        existingProduct.setAutheur(ouvrage.getAutheur());
        existingProduct.setNom(ouvrage.getNom());
        existingProduct.setDescription(ouvrage.getDescription());
        existingProduct.setQuantite(ouvrage.getQuantite());
        existingProduct.setUtilisateur(ouvrage.getUtilisateur());

        Utilisateur utilisateur =(Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ouvrage.setUtilisateur(utilisateur);
        this.ouvrageRepository.save(existingProduct);
    }
    @Override
    public Ouvrage getOuvrage(Integer id){
        return ouvrageRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Ouvrage> getOuvrages(){
        List<Ouvrage> ouvrages =new ArrayList<>();
        ouvrageRepository.findAll().forEach(ouvrage ->{
            ouvrages.add(ouvrage);


        });

        return ouvrages;
    }

}
