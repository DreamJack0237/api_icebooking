package com.example.icebooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.icebooking.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
