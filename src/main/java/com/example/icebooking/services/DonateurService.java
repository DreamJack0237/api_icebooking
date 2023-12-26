package com.example.icebooking.services;

import com.example.icebooking.models.Donateur;

import java.util.List;

public interface DonateurService {

    public void createDonateur(Donateur ouvrage);
    public  void deleteDonateur(Integer id);
    public Donateur getDonateur(Integer id);
    public List<Donateur> getDonateurs();

    public  void updateDonateur(Integer id,Donateur ouvrage);
}
