package com.example.icebooking.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.icebooking.models.Notation;
import com.example.icebooking.services.NotationServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/avis")
@AllArgsConstructor
public class NotationController {

    private final NotationServiceImpl avisService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void creerAvis(@RequestBody Notation avis) {
        this.avisService.createOrUpdateAvis(avis);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/{id}")
    public Notation getAvis(@PathVariable Integer id) {
        return avisService.getAvis(id);
    }

}
