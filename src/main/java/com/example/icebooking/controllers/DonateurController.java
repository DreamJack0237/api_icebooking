package com.example.icebooking.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import com.example.icebooking.models.Donateur;
import com.example.icebooking.models.Donateur;
import com.example.icebooking.services.DonatorServiceImpl;

@RestController
@RequestMapping("/donateurs")
public class DonateurController {
    private final DonatorServiceImpl donateurService;


    public DonateurController(DonatorServiceImpl donateurService) {
        this.donateurService = donateurService;
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/")
    public List<Donateur> listeDonateur(){
       return donateurService.getDonateurs();
  
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @PutMapping("/{id}")
    public void updateDonateur(@PathVariable Integer id, Donateur donateur){
        this.donateurService.updateDonateur(id,donateur);
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/{id}")
    public Donateur getDonateur( @PathVariable Integer id){
        return donateurService.getDonateur(id);
    }

}
