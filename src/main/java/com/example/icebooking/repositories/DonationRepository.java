package com.example.icebooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.icebooking.models.Donation;

public interface DonationRepository extends JpaRepository<Donation, Integer> {

}
