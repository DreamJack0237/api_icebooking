package com.example.icebooking.services;

import java.util.ArrayList;
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
    public void createLecture(Lecture lecture){
        this.lectureRepository.save(lecture);
    }
    @Override
    public void deleteLecture(Integer id){
        this.lectureRepository.deleteById(id);
    }
    @Override
    public void updateLecture(Integer id,Lecture lecture){
        this.lectureRepository.save(lecture);
    }
    @Override
    public Lecture getLecture(Integer id){
        return lectureRepository.findById(id).orElse(null);
    }

    @Override
    public List<Lecture> getLectures(){
        List<Lecture> lectures =new ArrayList<>();
        lectureRepository.findAll().forEach(lecture ->{
            lectures.add(lecture);

        });

        return lectures;
    }

}
