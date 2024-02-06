package com.example.icebooking.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.icebooking.models.Categorie;
import com.example.icebooking.models.Categorie;
import com.example.icebooking.services.CategorieServiceImpl;

import lombok.AllArgsConstructor;


@RequestMapping("/categories")
@RestController
@AllArgsConstructor
public class CategorieController {
    private final CategorieServiceImpl categorieService;

    @ResponseStatus(HttpStatus.CREATED )
    @PostMapping("/")
    public void creerCategorie(@RequestBody Categorie categorie){
        this.categorieService.createCategorie(categorie);
    }

    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("")
    public List<Categorie> listeCategorie(){
       return categorieService.getCategories();
  
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @DeleteMapping ("/{id}")
    public void deleteCategorie(@PathVariable Integer id){
        this.categorieService.deleteCategorie(id);
    }
    
    @ResponseStatus(HttpStatus.ACCEPTED )
    @PutMapping("/{id}")
    public void updateCategorie(@PathVariable Integer id,@RequestBody Categorie categorie){
        this.categorieService.updateCategorie(id,categorie);
    }


    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/{id}")
    public Categorie getCategorie(@PathVariable Integer id) {
        return categorieService.getCategorie(id);
    }
    

    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/{id}/ouvrages")
    public Categorie getCategorieOuvrages(@PathVariable Integer id){
        return categorieService.getCategorie(id);
    }

}
