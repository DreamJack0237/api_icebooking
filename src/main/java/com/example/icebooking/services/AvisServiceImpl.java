package com.example.icebooking.services;

import java.util.ArrayList;
import java.util.List;

import com.example.icebooking.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.icebooking.models.Avis;
import com.example.icebooking.repositories.AvisRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class AvisServiceImpl implements AvisService {
           @Autowired
    private final AvisRepository avisRepository;


    @Override
    public void createAvis(Avis avis){
        Utilisateur utilisateur =(Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        avis.setUtilisateur(utilisateur);
        this.avisRepository.save(avis);
    }
    @Override
    public void deleteAvis(Integer id){
        this.avisRepository.deleteById(id);
    }
    @Override
    public void updateAvis(Integer id,Avis avis){
        this.avisRepository.save(avis);
    }
    @Override
    public Avis getAvis(Integer id){
        return avisRepository.findById(id).orElse(null);
    }

    @Override
    public List<Avis> getAviss(){
        List<Avis> aviss =new ArrayList<>();
        avisRepository.findAll().forEach(avis ->{
            aviss.add(avis);

        });

        return aviss;
    }

}
