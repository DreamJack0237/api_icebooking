package com.example.icebooking.services;

import java.util.List;

import com.example.icebooking.models.Categorie;

public interface CategorieService {
    
    public void createCategorie(Categorie categorie);
    public  void deleteCategorie(Integer id);
    public Categorie getCategorie(Integer id);
    public List<Categorie> getCategories();

    public  void updateCategorie(Integer id,Categorie categorie);
}
