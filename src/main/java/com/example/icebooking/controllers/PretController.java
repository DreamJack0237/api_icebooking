package com.example.icebooking.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


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


    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/")
    public List<Pret> listePret(){
       return pretService.getPrets();
  
    }

    @ResponseStatus(HttpStatus.ACCEPTED )
    @patchMapping("/{id}")
    public void updatePret(@PathVariable Integer id, @RequestBody Pret pret){
        this.pretService.updatePret(id,pret);
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/{id}")
    public Pret getPret(@PathVariable Integer id){
        return pretService.getPret(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/{id}/items")
    public Pret getLignePret(@PathVariable Integer id){
        return pretService.getPret(id);
    }


}
