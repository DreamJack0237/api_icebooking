package com.example.icebooking.services;

import com.example.icebooking.models.Telechargement;

import java.util.List;

public interface DownloadService {

    //get information about a specific download
    public Telechargement getTelechargement(Integer id);

    //list all download
    public List<Telechargement> getTelechargements();
}
