package com.example.icebooking.services;


import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.icebooking.models.Utilisateur;

public interface UserService extends  UserDetailsService{

    //get all users lectures
    public void getUserLectures(Integer userId);

    //get all users comments
    public void getUserComments(Integer userId);

    //get all users download
    public void getUserDownloadings(Integer userId);

    //get all users
    public List<Utilisateur> getUsers();
    //get all activated users
    public List<Utilisateur>getActivatedUsers();
}
