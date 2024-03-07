package com.example.icebooking.models;

import java.io.Serializable;
import java.util.List;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ouvrage")
@Data
public class Ouvrage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "autheur")
    private String autheur;
    @Column(name = "description")
    private String description;
    @Column(name = "quantite")
    private Integer quantite;
    @Column(name = "version_num", nullable = true)

    private String version_num;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;
    @ManyToOne
    @JoinColumn(name = "categorie_id", nullable = false)
    private Categorie categorie;

    @OneToMany(mappedBy = "ouvrage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Avis> avis;

    @OneToMany(mappedBy = "ouvrage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Lecture> lectures;

    @OneToMany(mappedBy = "ouvrage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Telechargement> telechargements;

    @OneToMany(mappedBy = "ouvrage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Commentaire> commentaires;

    @ManyToMany
    @JoinTable(name = "ouvrage_categorie", joinColumns = @JoinColumn(name = "ouvrage_id"), inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    private List<Categorie> categories;

}
