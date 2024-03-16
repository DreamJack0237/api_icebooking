package com.example.icebooking.services;

import java.util.ArrayList;
import java.util.List;

import com.example.icebooking.models.Utilisateur;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.icebooking.models.Donator;
import com.example.icebooking.repositories.DonatorRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DonatorServiceImpl implements DonatorService {
    private final DonatorRepository donateurRepository;

    public void updateDonateur(Integer id, Donator donateur) {
        Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        donateur.setUtilisateur(utilisateur);
        this.donateurRepository.save(donateur);
    }

    @Override
    public Donator getDonateur(Integer id) {
        return donateurRepository.findById(id).orElse(null);
    }

    @Override
    public List<Donator> getDonateurs() {
        List<Donator> donateurs = new ArrayList<>();
        donateurRepository.findAll().forEach(donateur -> {
            donateurs.add(donateur);
        });
        return donateurs;
    }

}
