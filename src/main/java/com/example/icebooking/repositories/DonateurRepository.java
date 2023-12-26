package com.example.icebooking.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.icebooking.models.Donateur;

public interface DonateurRepository  extends CrudRepository <Donateur,Integer> {
    
}
