package com.example.icebooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.icebooking.models.Donator;

public interface DonatorRepository extends JpaRepository<Donator, Integer> {

}
