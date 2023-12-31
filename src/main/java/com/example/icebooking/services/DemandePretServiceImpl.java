package com.example.icebooking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.icebooking.models.DemandeDePret;
import com.example.icebooking.repositories.DemandePretRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class DemandePretServiceImpl implements DemandePretService {

    private final DemandePretRepository demandepretRepository;


    @Override
    public void createDemandePret(DemandeDePret demandepret){
        this.demandepretRepository.save(demandepret);
    }
    @Override
    public void deleteDemandePret(Integer id){
        this.demandepretRepository.deleteById(id);
    }
    @Override
    public void updateDemandePret(Integer id,DemandeDePret demandepret){
        this.demandepretRepository.save(demandepret);
    }
    @Override
    public DemandeDePret getDemandePret(Integer id){
        return demandepretRepository.findById(id).orElse(null);
    }

    @Override
    public List<DemandeDePret> getDemandePrets(){
        List<DemandeDePret> demandeprets =new ArrayList<>();
        demandepretRepository.findAll().forEach(demandepret ->{
            demandeprets.add(demandepret);

        });

        return demandeprets;
    }

}
