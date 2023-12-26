package com.example.icebooking.services;

import com.example.icebooking.models.Avis;

import java.util.List;

public interface AvisService {

    public void createAvis(Avis avis);
    public  void deleteAvis(Integer id);
    public Avis getAvis(Integer id);
    public List<Avis> getAviss();

    public  void updateAvis(Integer id,Avis avis);
}
