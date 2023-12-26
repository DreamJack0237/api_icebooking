package com.example.icebooking.services;

import com.example.icebooking.models.Don;

import java.util.List;

public interface DonService {

    public void createDon(Don don);
    public  void deleteDon(Integer id);
    public Don getDon(Integer id);
    public List<Don> getDons();

    public  void updateDon(Integer id,Don don);
}
