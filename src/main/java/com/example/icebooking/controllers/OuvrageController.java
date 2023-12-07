package com.example.icebooking.controllers;


import com.example.icebooking.models.Ouvrage;
import com.example.icebooking.service.OuvrageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.List;

@RequestMapping(value = "Ouvrage")
@RestController
public class OuvrageController {
    private final OuvrageService ouvrageService;


    public OuvrageController(OuvrageService ouvrageService) {
        this.ouvrageService = ouvrageService;
    }
    @ResponseStatus(HttpStatus.CREATED )
    @PostMapping("/createOuvrage")
    public void Creer(@RequestBody Ouvrage ouvrage){
        this.ouvrageService.CreateOuvrage(ouvrage);
    }

    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/listeOuvrage")
    public List<Ouvrage> listeOuvrage(){
        return ouvrageService.GetOuvrages();
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @DeleteMapping ("/deleteOuvrage/{id}")
    public void Delete(Integer id){
        this.ouvrageService.DeleteOuvrage(id);
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @PutMapping("/updateOuvrage/{id}")
    public void Update(Integer id, Ouvrage ouvrage){
        this.ouvrageService.UpdateOuvrage(id,ouvrage);
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/Ouvrage/{id}")
    public Ouvrage Ouvrage(Integer id){
        return ouvrageService.getOuvrage(id);
    }


}
