package com.example.icebooking.services;

import com.example.icebooking.models.Telechargement;

import java.util.List;

public interface TelechargementService {
    public void createTelechargement(Telechargement ouvrage);
    public  void deleteTelechargement(Integer id);
    public Telechargement getTelechargement(Integer id);
    public List<Telechargement> getTelechargements();

    public  void updateTelechargement(Integer id,Telechargement ouvrage);
    
}
