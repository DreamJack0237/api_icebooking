package com.example.icebooking.services;

import com.example.icebooking.models.Avis;

import java.util.List;

public interface NotationService {

    //cre
    public void createOrUpdateAvis(Avis avis);
    public Avis getAvis(Integer id);
    public List<Avis> getAviss();
}
