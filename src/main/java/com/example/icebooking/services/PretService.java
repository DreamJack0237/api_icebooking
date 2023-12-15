package com.example.icebooking.services;

import java.util.List;

import com.example.icebooking.models.Ouvrage;
import com.example.icebooking.models.Pret;

public interface PretService {

    Ouvrage createPret(Pret pret);

    Ouvrage updatePret(Pret pret,long id);

    List<Ouvrage> getAllPrets();

    Ouvrage getPret(long id);
    
    String deletePret(long id);
} 