package com.example.icebooking.services;

import com.example.icebooking.models.Commentaire;

import java.util.List;

public interface CommentaireService {

    public void createCommentaire(Commentaire commentaire);
    public  void deleteCommentaire(Integer id);
    public Commentaire getCommentaire(Integer id);
    public List<Commentaire> getCommentaires();

    public  void updateCommentaire(Integer id,Commentaire commentaire);
}
