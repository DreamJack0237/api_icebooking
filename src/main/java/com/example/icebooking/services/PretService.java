package com.example.icebooking.services;

import java.util.List;

import com.example.icebooking.models.Ouvrage;
import com.example.icebooking.models.Pret;

public interface PretService {

    List<Pret> getPrets();

    Pret getPret(Integer id);

    String backPret(Integer id);
}