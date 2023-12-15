package com.example.icebooking.services;

import com.example.icebooking.models.Ouvrage;

import java.util.List;

public class OuvrageServiceImpl implements  OuvrageService {


    private final  OuvrageRepository  ouvrageRepository;
        @Override
    public Ouvrage createOuvrage(Ouvrage ouvrage) {
        return ouvrageRepository.save(ouvrage);
    }

    @Override
    public Ouvrage updateOuvrage(Ouvrage ouvrage,long id) {
        // TODO Auto-generated method stub
        return  ouvragerepository.findById(id).map(p->
        {
           return  ouvrageRepository.save(p);
        }).orElseThrow();
    }

    @Override
    public List<Ouvrage> getAllOuvrages() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllOuvrages'");
    }


    @Override
    public Ouvrage getOuvrage(long id) {
        // TODO Auto-generated method stub
        return ouvrageRepository.findById(id).orElseThrow();
    }

    @Override
    public String deleteOuvrage(long id) {
        // TODO Auto-generated method stub
        ouvrageRepository.deleteById(id);
        return "ok";
    }
}
