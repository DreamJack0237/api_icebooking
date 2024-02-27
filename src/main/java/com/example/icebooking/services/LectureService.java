package com.example.icebooking.services;

import com.example.icebooking.models.Lecture;


import java.util.List;

public interface LectureService {
     //get the information about a specific lecture 
    public Lecture getLecture(Integer id);
    //get the list of all lecture 
    public List<Lecture> getLectures();
    
}
