package com.example.icebooking.services;

import java.util.List;

import com.example.icebooking.models.Ouvrage;

public interface OuvrageService {
    Ouvrage createOuvrage(Ouvrage ouvrage);

    Ouvrage updateOuvrage(Ouvrage ouvrage,long id);

    List<Ouvrage> getAllOuvrages();

    Ouvrage getOuvrage(long id);
    
    String deleteOuvrage(long id);

}
