package com.example.icebooking.services;

import com.example.icebooking.models.Comment;

public interface CommentService {

    // create a new comment
    public void createCommentaire(Comment commentaire);

    // delete a comment
    public void deleteCommentaire(Integer id);

    // get information about a specific comment
    public Comment getCommentaire(Integer id);

    // update message in a commentaire
    public void updateCommentaire(Integer id, Comment commentaire);
}
