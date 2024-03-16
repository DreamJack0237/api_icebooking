package com.example.icebooking.services;

import com.example.icebooking.models.Donator;

import java.util.List;

public interface DonatorService {

    // get a donator information
    public Donator getDonateur(Integer id);

    // get all donators
    public List<Donator> getDonateurs();

    // update Donator
    public void updateDonateur(Integer id, Donator ouvrage);
}
