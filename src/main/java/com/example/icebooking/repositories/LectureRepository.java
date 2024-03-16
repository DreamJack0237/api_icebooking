package com.example.icebooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.icebooking.models.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {

}
