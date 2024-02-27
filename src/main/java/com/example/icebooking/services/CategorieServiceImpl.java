package com.example.icebooking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.icebooking.models.Categorie;
import com.example.icebooking.models.Ouvrage;
import com.example.icebooking.repositories.CategorieRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategorieServiceImpl implements CategoryService {
    @Autowired
    private final CategorieRepository categorieRepository;

    @Override
    public void createCategorie(Categorie categorie) {

        this.categorieRepository.save(categorie);
    }

    @Override
    public void deleteCategorie(Integer id) {
        this.categorieRepository.deleteById(id);
    }

    @Override
    public void updateCategorie(Integer id, Categorie categorie) {

        this.categorieRepository.save(categorie);
    }

    @Override
    public Categorie getCategorie(Integer id) {
        return categorieRepository.findById(id).orElse(null);
    }

    @Override
    public List<Categorie> getCategories() {
        List<Categorie> categories = new ArrayList<>();
        categorieRepository.findAll().forEach(categorie -> {
            categories.add(categorie);

        });

        return categories;
    }

    @Override
    public List<Ouvrage> getCategoryBook(Integer categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCategoryBook'");
    }

}
