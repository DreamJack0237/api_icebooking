package com.example.icebooking.models;

import java.io.Serializable;
import java.util.List;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ouvrage")
@Data
public class Ouvrage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "autheur")
    private String autheur;
    @Column(name = "description")
    private String description;
    @Column(name = "quantite")
    private Integer quantite = 1;

    private String imagePath;

    private String filePath;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = true)
    private Utilisateur creator;

    @OneToMany(mappedBy = "ouvrage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Notation> avis;

    @OneToMany(mappedBy = "ouvrage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Lecture> lectures;

    @OneToMany(mappedBy = "ouvrage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Download> telechargements;

    @OneToMany(mappedBy = "ouvrage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> commentaires;

    @ManyToMany
    @JoinTable(name = "ouvrage_categorie", joinColumns = @JoinColumn(name = "ouvrage_id"), inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    private List<Category> categories;

}
