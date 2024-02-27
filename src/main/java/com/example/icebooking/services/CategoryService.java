package com.example.icebooking.services;

import java.util.List;

import com.example.icebooking.models.Categorie;
import com.example.icebooking.models.Ouvrage;

public interface CategoryService {
    

    //create az new category
    public void createCategorie(Categorie categorie);
    // delete a categorie
    public  void deleteCategorie(Integer id);
    //get information about et specific category
    public Categorie getCategorie(Integer id);
    //get all categories
    public List<Categorie> getCategories();

    //get book categories
    public List<Ouvrage> getCategoryBook(Integer categoryId);
    //update a categories informations 
    public  void updateCategorie(Integer id,Categorie categorie);
}
