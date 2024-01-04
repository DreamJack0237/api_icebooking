package com.example.icebooking.services;

import com.example.icebooking.models.Ouvrage;
import com.example.icebooking.repositories.OuvrageRepository;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public interface OuvrageService {
public void createOuvrage(Ouvrage ouvrage);
public  void deleteOuvrage(Integer id);


public Ouvrage getOuvrage(Integer id);
public List<Ouvrage> getOuvrages();

public  void updateOuvrage(Integer id,Ouvrage ouvrage);

}
