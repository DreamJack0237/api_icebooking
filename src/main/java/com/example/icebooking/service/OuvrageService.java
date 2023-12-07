package com.example.icebooking.service;

import com.example.icebooking.models.Ouvrage;
import com.example.icebooking.repository.OuvrageRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class OuvrageService {
    @Autowired
    private final OuvrageRepository ouvrageRepository;



    public void CreateOuvrage(Ouvrage ouvrage){
        this.ouvrageRepository.save(ouvrage);
    }
    public void DeleteOuvrage(Integer id){
        this.ouvrageRepository.deleteById(id);
    }
    public void UpdateOuvrage(Integer id,Ouvrage ouvrage){
        this.ouvrageRepository.save(ouvrage);
    }
    public Ouvrage getOuvrage(Integer id){
       return ouvrageRepository.findById(id).orElse(null);
    }
    public List<Ouvrage> GetOuvrages(){
        List<Ouvrage> ouvrages =new ArrayList<>();
        ouvrageRepository.findAll().forEach(ouvrage ->{
            ouvrages.add(ouvrage);

    });

        return ouvrages;
    }


}
