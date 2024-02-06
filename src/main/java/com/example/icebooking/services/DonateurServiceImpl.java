package com.example.icebooking.services;

import java.util.ArrayList;
import java.util.List;

import com.example.icebooking.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.icebooking.models.Donateur;
import com.example.icebooking.repositories.DonateurRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DonateurServiceImpl implements DonateurService {
    private final DonateurRepository donateurRepository;
    @Override
    public void createDonateur(Donateur donateur){
        Utilisateur utilisateur =(Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        donateur.setUtilisateur(utilisateur);
        this.donateurRepository.save(donateur);
    }
    @Override
    public void deleteDonateur(Integer id){
        this.donateurRepository.deleteById(id);
    }
    @Override
    public void updateDonateur(Integer id,Donateur donateur){
        Utilisateur utilisateur =(Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        donateur.setUtilisateur(utilisateur);
        this.donateurRepository.save(donateur);
    }
    @Override
    public Donateur getDonateur(Integer id){
        return donateurRepository.findById(id).orElse(null);
    }
    @Override
    public List<Donateur> getDonateurs(){
        List<Donateur> donateurs =new ArrayList<>();
        donateurRepository.findAll().forEach(donateur ->{
            donateurs.add(donateur);
        });
        return donateurs;
    }

}
