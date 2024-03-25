package com.example.icebooking.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.icebooking.Dto.LoanRequestDto;
import com.example.icebooking.models.Pret;
import com.example.icebooking.services.PretServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/prets")
public class LoanController {
    private final PretServiceImpl pretService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping
    public List<Pret> listePret() {
        return pretService.getPrets();

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Pret createLoan(@RequestBody LoanRequestDto loanDto) {

        return pretService.createPret(loanDto);
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
