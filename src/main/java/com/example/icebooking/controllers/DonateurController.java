package com.example.icebooking.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.icebooking.models.Donator;
import com.example.icebooking.services.DonatorServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/donateurs")
@AllArgsConstructor
public class DonateurController {
    private final DonatorServiceImpl donateurService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/")
    public List<Donator> listeDonateur() {
        return donateurService.getDonateurs();

    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public void updateDonateur(@PathVariable Integer id, Donator donateur) {
        this.donateurService.updateDonateur(id, donateur);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/{id}")
    public Donator getDonateur(@PathVariable Integer id) {
        return donateurService.getDonateur(id);
    }

}
