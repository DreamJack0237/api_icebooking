package com.example.icebooking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.icebooking.models.Validation;

public interface ValidationRepository extends JpaRepository<Validation, Integer> {

   Optional<Validation> findByCode(String code);

}
