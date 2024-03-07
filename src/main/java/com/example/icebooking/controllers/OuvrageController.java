package com.example.icebooking.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.icebooking.models.Ouvrage;
import com.example.icebooking.services.BookServiceImpl;

@RequestMapping("/ouvrages")
@RestController
public class OuvrageController {
    private final BookServiceImpl ouvrageService;

    public OuvrageController(BookServiceImpl ouvrageService) {
        this.ouvrageService = ouvrageService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void creerOuvrage(@RequestBody Ouvrage ouvrage) {

        this.ouvrageService.createOuvrage(ouvrage);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Ouvrage> listeOuvrage() {
        return ouvrageService.getOuvrages();

    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping
    public void deleteOuvrage(@PathVariable Integer id) {
        this.ouvrageService.deleteOuvrage(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping
    public void updateOuvrage(@PathVariable Integer id, @RequestBody Ouvrage ouvrage) {
        this.ouvrageService.updateOuvrage(id, ouvrage);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Ouvrage getOuvrage(@PathVariable Integer id) {
        return ouvrageService.getOuvrage(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/{id}/categories")
    public Ouvrage addOuvrageCategory(@PathVariable Integer id) {
        return ouvrageService.getOuvrage(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/{id}/avis")
    public Ouvrage getAvisOuvrage(@PathVariable Integer id) {
        return ouvrageService.getOuvrage(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/{id}/comments")
    public Ouvrage getCommentaireOuvrage(@PathVariable Integer id) {
        return ouvrageService.getOuvrage(id);
    }

}
