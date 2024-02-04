package com.example.icebooking.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.icebooking.models.Avis;
import com.example.icebooking.models.Avis;
import com.example.icebooking.services.AvisServiceImpl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/avis")
public class AvisController {

    private final AvisServiceImpl avisService;


    public AvisController(AvisServiceImpl avisService) {
        this.avisService = avisService;
    }
    @ResponseStatus(HttpStatus.CREATED )
    @PostMapping("/")
    public void creerAvis(@RequestBody Avis avis){
        this.avisService.createAvis(avis);
    }

    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("")
    public List<Avis> listeAvis(){
       return avisService.getAviss();
  
    }




    @ResponseStatus(HttpStatus.ACCEPTED )
    @DeleteMapping ("/{id}")
    public void deleteAvis(@PathVariable Integer id){
        this.avisService.deleteAvis(id);
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @PutMapping("/{id}")
    public void updateAvis(@PathVariable Integer id, @RequestBody Avis avis){
        this.avisService.updateAvis(id,avis);
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/{id}")
    public Avis getAvis(@PathVariable Integer id){
        return avisService.getAvis(id);
    }


}
