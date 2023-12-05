package com.example.icebooking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="ouvrage")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Ouvrage implements Serializable {
    @Id
    private Integer id;
    @Column(name="nom_ouvrage")
    private String nom_ouvrage;
    @Column(name="auteurr")
    private String auteurr;
    @Column(name="descriiption")
    private String descriiption;
    @Column(name="quantite")
    private Integer quantite;
    @Column(name="version_num")
    private String version_num;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "ouvrage",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Avis> avis;

    @OneToMany(mappedBy = "ouvrage",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Lecture> lectures;

    @OneToMany(mappedBy = "ouvrage",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Telechargement> telechargements;

    @OneToMany(mappedBy = "ouvrage",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Commentaire> commentaires;

    @OneToMany(mappedBy = "ouvrage",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<LigneDePret> ligneDePrets;


    @ManyToMany
    @JoinTable(
            name = "ouvrage_categorie",
            joinColumns = @JoinColumn(name = "ouvrage_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    private List<Categorie> categories;

}
