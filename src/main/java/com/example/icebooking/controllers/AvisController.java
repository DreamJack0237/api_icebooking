package com.example.icebooking.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.icebooking.models.Avis;
import com.example.icebooking.services.NotationServiceImpl;

@RestController
@RequestMapping("/avis")
public class AvisController {

    private final NotationServiceImpl avisService;

    //
    public AvisController(NotationServiceImpl avisService) {
        this.avisService = avisService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void creerAvis(@RequestBody Avis avis) {
        this.avisService.createOrUpdateAvis(avis);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/{id}")
    public Avis getAvis(@PathVariable Integer id) {
        return avisService.getAvis(id);
    }

}
