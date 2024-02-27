package com.example.icebooking.services;

import com.example.icebooking.models.Don;

import java.util.List;

public interface DonationService {

    //create a donnation
    public void createDon(Don don);
    //get information  about a specific donation
    public Don getDon(Integer id);
    //get all donations 
    public List<Don> getDons();

    //update a donation
    public  void updateDon(Integer id,Don don);

    //get  donator donations
    public  List<Don>  getDonatorDonations(Integer id);
}
