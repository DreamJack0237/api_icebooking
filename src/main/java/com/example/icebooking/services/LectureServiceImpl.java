package com.example.icebooking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.icebooking.models.Lecture;
import com.example.icebooking.repositories.LectureRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LectureServiceImpl implements LectureService {
    @Autowired
    private final LectureRepository lectureRepository;

    @Override
    public Lecture getLecture(Integer id) {
        return lectureRepository.findById(id).orElse(null);
    }

    @Override
    public List<Lecture> getLectures() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method'getLectures'");
    }

}
