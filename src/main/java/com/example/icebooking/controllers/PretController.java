package com.example.icebooking.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.icebooking.models.Pret;
import com.example.icebooking.services.PretServiceImpl;

@RestController
@RequestMapping("/prets")
public class PretController {
    private final PretServiceImpl pretService;

    public PretController(PretServiceImpl pretService) {
        this.pretService = pretService;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/")
    public List<Pret> listePret() {
        return pretService.getPrets();

    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/{id}")
    public Pret getPret(@PathVariable Integer id) {
        return pretService.getPret(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/{id}")
    public Pret endPret(@PathVariable Integer id) {
        return pretService.getPret(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/{id}/items")
    public Pret getLignePret(@PathVariable Integer id) {
        return pretService.getPret(id);
    }

}
