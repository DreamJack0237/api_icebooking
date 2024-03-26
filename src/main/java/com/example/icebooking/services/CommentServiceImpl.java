package com.example.icebooking.services;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.icebooking.models.Comment;
import com.example.icebooking.models.Utilisateur;
import com.example.icebooking.repositories.CommentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private final CommentRepository commentRepository;

    @Override
    public void createCommentaire(Comment commentaire) {
        // Utilisateur utilisateur = (Utilisateur)
        // SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // commentaire.setUtilisateur(utilisateur);
        this.commentRepository.save(commentaire);
    }

    @Override
    public void deleteCommentaire(Integer id) {
        this.commentRepository.deleteById(id);
    }

    @Override
    public void updateCommentaire(Integer id, Comment commentaire) {
        // Utilisateur utilisateur = (Utilisateur)
        // SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // commentaire.setUtilisateur(utilisateur);
        this.commentRepository.save(commentaire);
    }

    @Override
    public Comment getCommentaire(Integer id) {
        return commentRepository.findById(id).orElse(null);
    }
}