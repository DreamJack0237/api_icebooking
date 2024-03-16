package com.example.icebooking.services;

import java.util.List;

import com.example.icebooking.models.Category;
import com.example.icebooking.models.Ouvrage;

public interface CategoryService {

    // create az new category
    public void createCategorie(Category categorie);

    // delete a categorie
    public void deleteCategorie(Integer id);

    // get information about et specific category
    public Category getCategorie(Integer id);

    // get all categories
    public List<Category> getCategories();

    // get book categories
    public List<Ouvrage> getCategoryBook(Integer categoryId);

    // update a categories informations
    public void updateCategorie(Integer id, Category categorie);
}
