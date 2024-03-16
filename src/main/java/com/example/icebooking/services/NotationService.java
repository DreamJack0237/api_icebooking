package com.example.icebooking.services;

import com.example.icebooking.models.Notation;

import java.util.List;

public interface NotationService {

    // cre
    public void createOrUpdateAvis(Notation avis);

    public Notation getAvis(Integer id);

    public List<Notation> getAviss();
}
