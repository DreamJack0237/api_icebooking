package com.example.icebooking.services;

import java.util.ArrayList;
import java.util.List;

import com.example.icebooking.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.icebooking.models.Notation;
import com.example.icebooking.repositories.NotationRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class NotationServiceImpl implements NotationService {
    @Autowired
    private final NotationRepository avisRepository;

    @Override
    public void createOrUpdateAvis(Notation avis) {
        Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        avis.setOwner(utilisateur);
        this.avisRepository.save(avis);
    }

    @Override
    public Notation getAvis(Integer id) {
        return avisRepository.findById(id).orElse(null);
    }

    @Override
    public List<Notation> getAviss() {
        List<Notation> aviss = new ArrayList<>();
        avisRepository.findAll().forEach(avis -> {
            aviss.add(avis);

        });

        return aviss;
    }

}
