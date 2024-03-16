package com.example.icebooking.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.icebooking.models.Pret;
import com.example.icebooking.services.PretServiceImpl;

@RestController
@RequestMapping("/prets")
public class LoanController {
    private final PretServiceImpl pretService;

    public LoanController(PretServiceImpl pretService) {
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
    @GetMapping("/{id}/ouvrages")
    public Pret getLignePret(@PathVariable Integer id) {
        return pretService.getPret(id);
    }

}
