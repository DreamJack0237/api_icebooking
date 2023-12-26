package com.example.icebooking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.icebooking.models.Commentaire;
import com.example.icebooking.repositories.CommentaireRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class CommentaireServiceImpl implements CommentaireService {
    @Autowired
    private final CommentaireRepository commentaireRepository;


    @Override
    public void createCommentaire(Commentaire commentaire){
        this.commentaireRepository.save(commentaire);
    }
    @Override
    public void deleteCommentaire(Integer id){
        this.commentaireRepository.deleteById(id);
    }
    @Override
    public void updateCommentaire(Integer id,Commentaire commentaire){
        this.commentaireRepository.save(commentaire);
    }
    @Override
    public Commentaire getCommentaire(Integer id){
        return commentaireRepository.findById(id).orElse(null);
    }

    @Override
    public List<Commentaire> getCommentaires(){
        List<Commentaire> commentaires =new ArrayList<>();
        commentaireRepository.findAll().forEach(commentaire ->{
            commentaires.add(commentaire);

        });

        return commentaires;
    }

}
