package com.example.icebooking.services;

import com.example.icebooking.models.Donateur;

import java.util.List;

public interface DonatorService {

    //get a donator information
    public Donateur getDonateur(Integer id);

    //get all donators
    public List<Donateur> getDonateurs();

    //update Donator
    public  void updateDonateur(Integer id,Donateur ouvrage);
}
