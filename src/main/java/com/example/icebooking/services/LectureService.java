package com.example.icebooking.services;

import com.example.icebooking.models.Lecture;
import com.example.icebooking.models.Lecture;
import com.example.icebooking.models.Ouvrage;

import java.util.List;

public interface LectureService {
     public void createLecture(Lecture lecture);
    public Lecture getLecture(Integer id);
    public List<Lecture> getLectures();

    public  void updateLecture(Integer id,Lecture lecture);
    
}
