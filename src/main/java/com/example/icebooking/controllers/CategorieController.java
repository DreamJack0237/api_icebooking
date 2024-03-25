package com.example.icebooking.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.icebooking.models.Category;
import com.example.icebooking.services.CategoryServiceImpl;

import lombok.AllArgsConstructor;

@RequestMapping("/categories")
@RestController
@AllArgsConstructor
public class CategorieController {
    private final CategoryServiceImpl categorieService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void creerCategorie(@RequestBody Category categorie) {
        this.categorieService.createCategorie(categorie);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping
    public List<Category> listeCategorie() {
        return categorieService.getCategories();

    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{id}")
    public void deleteCategorie(@PathVariable Integer id) {
        this.categorieService.deleteCategorie(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public void updateCategorie(@PathVariable Integer id, @RequestBody Category categorie) {
        this.categorieService.updateCategorie(id, categorie);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/{id}")
    public Category getCategorie(@PathVariable Integer id) {
        return categorieService.getCategorie(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/{id}/ouvrages")
    public Category getCategorieOuvrages(@PathVariable Integer id) {
        return categorieService.getCategorie(id);
    }

}
