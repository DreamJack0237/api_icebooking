package com.example.icebooking.services;

import java.util.List;

import com.example.icebooking.models.Utilisateur;

public interface UserService {

    // get all users lectures
    public void getUserLectures(Integer userId);

    // get all users comments
    public void getUserComments(Integer userId);

    // get all users download
    public void getUserDownloadings(Integer userId);

    // get all users
    public List<Utilisateur> getUsers();

    // get all activated users
    public List<Utilisateur> getActivatedUsers();
}
