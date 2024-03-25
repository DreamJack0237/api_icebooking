package com.example.icebooking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.icebooking.models.Category;
import com.example.icebooking.models.Ouvrage;

public interface BookRepository extends JpaRepository<Ouvrage, String> {
    List<Ouvrage> findByCategories(Category category);

}
