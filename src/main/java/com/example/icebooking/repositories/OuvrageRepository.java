package com.example.icebooking.repositories;

import com.example.icebooking.models.Ouvrage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.context.SecurityContextHolder;

public interface OuvrageRepository extends CrudRepository <Ouvrage,Integer>{



}
