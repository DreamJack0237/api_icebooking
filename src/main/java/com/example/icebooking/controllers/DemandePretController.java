package com.example.icebooking.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.icebooking.models.DemandeDePret;
import com.example.icebooking.services.DemandePretServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/demandeprets")
@AllArgsConstructor
public class DemandePretController {
    private final DemandePretServiceImpl demandepretService;

    @ResponseStatus(HttpStatus.CREATED )
    @PostMapping("{id}/validate")
    public void validatePret(@RequestBody DemandeDePret demandePret){
        this.demandepretService.createDemandePret(demandePret);
    }
    @ResponseStatus(HttpStatus.CREATED )
    @PostMapping("{id}/reject")
    public void rejectPret(@RequestBody DemandeDePret demandePret){
        this.demandepretService.createDemandePret(demandePret);
    }


    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/")
    public List<DemandeDePret> listeDemandePret(){
       return demandepretService.getDemandePrets();
  
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @DeleteMapping ("/{id}")
    public void deleteDemandePret(@PathVariable Integer id){
        this.demandepretService.deleteDemandePret(id);
    }
    @ResponseStatus(HttpStatus.ACCEPTED )
    @PutMapping("/{id}")
    public void updateDemandePret(@PathVariable Integer id, @RequestBody DemandeDePret demandePret){
        this.demandepretService.updateDemandePret(id,demandePret);
    }

    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/{id}")
    public DemandeDePret getDemandePret(@PathVariable Integer id){
        return demandepretService.getDemandePret(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED )
    @GetMapping("/{id}/lignePret")
    public DemandeDePret getDemandePret(@PathVariable Integer id){
        return demandepretService.getDemandePret(id);
    }

}
