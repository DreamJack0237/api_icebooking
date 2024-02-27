package com.example.icebooking.services;

import com.example.icebooking.models.Commentaire;

import java.util.List;

public interface CommentService {


    //create a new comment 
    public void createCommentaire(Commentaire commentaire);

    //delete a comment 
    public  void deleteCommentaire(Integer id);

    //get information about a specific comment 
    public Commentaire getCommentaire(Integer id);
    //get   all comments
    public List<Commentaire> getCommentaires();

    //update message in a commentaire 
    public  void updateCommentaire(Integer id,Commentaire commentaire);
}
