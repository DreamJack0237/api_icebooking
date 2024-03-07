package com.example.icebooking.models;

import jakarta.persistence.*;

import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "commentaire")
@Data
public class Commentaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "ouvrage_id")
    private Ouvrage ouvrage;
}
