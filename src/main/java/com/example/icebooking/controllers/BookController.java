package com.example.icebooking.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.icebooking.models.Ouvrage;
import com.example.icebooking.services.BookServiceImpl;

@RequestMapping("/ouvrages")
@RestController
public class BookController {
    private final BookServiceImpl ouvrageService;

    public BookController(BookServiceImpl ouvrageService) {
        this.ouvrageService = ouvrageService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void creerOuvrage(@ModelAttribute(name = "book") Ouvrage ouvrage,
            @RequestParam(name = "file", required = false) MultipartFile file,
            @RequestParam("image") MultipartFile image) {

        this.ouvrageService.createOuvrage(ouvrage, file, image);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Ouvrage> listeOuvrage() {
        return ouvrageService.getOuvrages();

    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping
    public void deleteOuvrage(@PathVariable String id) {
        this.ouvrageService.deleteOuvrage(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping
    public void updateOuvrage(@PathVariable String id, @RequestBody Ouvrage ouvrage,
            @RequestParam(name = "file", required = false) MultipartFile file,
            @RequestParam("image") MultipartFile image) {
        this.ouvrageService.updateOuvrage(id, ouvrage, file, image);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Ouvrage getOuvrage(@PathVariable String id) {
        return ouvrageService.getOuvrage(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/download")
    public ResponseEntity<?> DownloadOuvrage(@PathVariable String id) {
        return ouvrageService.downloadBook(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/{id}/categories")
    public Ouvrage addOuvrageCategory(@PathVariable String id) {
        return ouvrageService.getOuvrage(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/{id}/avis")
    public Ouvrage getAvisOuvrage(@PathVariable String id) {
        return ouvrageService.getOuvrage(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/{id}/comments")
    public Ouvrage getCommentaireOuvrage(@PathVariable String id) {
        return ouvrageService.getOuvrage(id);
    }

}
