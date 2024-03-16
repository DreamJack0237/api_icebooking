package com.example.icebooking.services;

import com.example.icebooking.models.Donation;

import java.util.List;

public interface DonationService {

    // create a donnation
    public void createDon(Donation don);

    // get information about a specific donation
    public Donation getDon(Integer id);

    // get all donations
    public List<Donation> getDons();

    // update a donation
    public void updateDon(Integer id, Donation don);

    // get donator donations
    public List<Donation> getDonatorDonations(Integer id);
}
