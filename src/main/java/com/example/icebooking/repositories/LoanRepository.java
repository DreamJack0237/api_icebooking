package com.example.icebooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.icebooking.models.Pret;

public interface LoanRepository extends JpaRepository<Pret, Integer> {

}
