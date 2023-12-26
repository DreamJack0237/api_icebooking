package com.example.icebooking.services;

import java.util.List;

import com.example.icebooking.models.Ouvrage;
import com.example.icebooking.models.Pret;

public interface PretService {

    Pret createPret(Pret pret);

    Pret updatePret(Integer id,Pret pret);

    List<Pret> getPrets();

    Pret getPret(Integer id);
    
    String deletePret(Integer id);
} 