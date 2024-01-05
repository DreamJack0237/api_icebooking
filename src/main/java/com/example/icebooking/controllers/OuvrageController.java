package com.example.icebooking.controllers;


import com.example.icebooking.models.Ouvrage;
import com.example.icebooking.models.Utilisateur;
import com.example.icebooking.services.OuvrageService;
import com.example.icebooking.services.OuvrageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import java.util.List;

//@RequestMapping("/ouvrages")
@RestController
public class OuvrageController {
    private final OuvrageServiceImpl ouvrageService;


    public OuvrageController(OuvrageServiceImpl ouvrageService) {
        this.ouvrageService = ouvrageService;
    }
    @ResponseStatus(HttpStatus.CREATED )
    @PostMapping("createOuvrage")
    public void creerOuvrage(@RequestBody Ouvrage ouvrage){

        this.ouvrageService.createOuvrage(ouvrage);
    }

    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("")
    public List<Ouvrage> listeOuvrage(){
       return ouvrageService.getOuvrages();
  
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @DeleteMapping ("/{id}")
    public void deleteOuvrage(@PathVariable Integer id){
        this.ouvrageService.deleteOuvrage(id);
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @PutMapping("/{id}")
    public void updateOuvrage(@PathVariable Integer id,@RequestBody Ouvrage ouvrage){
        this.ouvrageService.updateOuvrage(id,ouvrage);
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/{id}")
    public Ouvrage getOuvrage(@PathVariable Integer id) {
        return ouvrageService.getOuvrage(id);
    }
    
    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/{id}/avis")
    public Ouvrage getAvisOuvrage(@PathVariable Integer id) {
        return ouvrageService.getOuvrage(id);
    }
    
        
    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/{id}/comments")
    public Ouvrage getCommentaireOuvrage( @PathVariable Integer id){
        return ouvrageService.getOuvrage(id);
    }




}
