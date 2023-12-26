package com.example.icebooking.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.icebooking.models.Pret;
import com.example.icebooking.models.Pret;
import com.example.icebooking.services.PretServiceImpl;

@RestController
@RequestMapping("/prets")

public class PretController {
    private final PretServiceImpl pretService;


    public PretController(PretServiceImpl pretService) {
        this.pretService = pretService;
    }
    @ResponseStatus(HttpStatus.CREATED )
    @PostMapping("/")
    public void creerPret(@RequestBody Pret pret){
        this.pretService.createPret(pret);
    }

    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/")
    public List<Pret> listePret(){
       return pretService.getPrets();
  
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @DeleteMapping ("/{id}")
    public void deletePret(@PathVariable Integer id){
        this.pretService.deletePret(id);
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @PutMapping("/{id}")
    public void updatePret(@PathVariable Integer id, @RequestBody Pret pret){
        this.pretService.updatePret(id,pret);
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/{id}")
    public Pret getPret(@PathVariable Integer id){
        return pretService.getPret(id);
    }

}
