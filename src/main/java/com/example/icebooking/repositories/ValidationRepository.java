package com.example.icebooking.repositories;

import com.example.icebooking.models.Validation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ValidationRepository extends CrudRepository <Validation,Integer> {

   Optional<Validation> findByCode(String code);

}