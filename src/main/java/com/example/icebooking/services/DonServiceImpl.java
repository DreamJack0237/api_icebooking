package com.example.icebooking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.icebooking.models.Don;
import com.example.icebooking.repositories.DonRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class DonServiceImpl implements DonService {
           @Autowired
    private final DonRepository donRepository;


    @Override
    public void createDon(Don don){
        this.donRepository.save(don);
    }
    @Override
    public void deleteDon(Integer id){
        this.donRepository.deleteById(id);
    }
    @Override
    public void updateDon(Integer id,Don don){
        this.donRepository.save(don);
    }
    @Override
    public Don getDon(Integer id){
        return donRepository.findById(id).orElse(null);
    }

    @Override
    public List<Don> getDons(){
        List<Don> dons =new ArrayList<>();
        donRepository.findAll().forEach(don ->{
            dons.add(don);

        });

        return dons;
    }

}
