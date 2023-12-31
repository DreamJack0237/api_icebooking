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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nom")
    private String nom;
    @Column(name="autheur")
    private String autheur;
    @Column(name="description")
    private String description;
    @Column(name="quantite")
    private Integer quantite;
    @Column(name="version_num")
    private String version_num;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id",nullable = true)
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

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAutheur() {
        return autheur;
    }

    public String getDescription() {
        return description;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public String getVersion_num() {
        return version_num;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public List<Avis> getAvis() {
        return avis;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public List<Telechargement> getTelechargements() {
        return telechargements;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public List<LigneDePret> getLigneDePrets() {
        return ligneDePrets;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAutheur(String auteurr) {
        this.autheur = auteurr;
    }

    public void setDescription(String descriiption) {
        this.description = descriiption;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public void setVersion_num(String version_num) {
        this.version_num = version_num;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setAvis(List<Avis> avis) {
        this.avis = avis;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public void setTelechargements(List<Telechargement> telechargements) {
        this.telechargements = telechargements;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public void setLigneDePrets(List<LigneDePret> ligneDePrets) {
        this.ligneDePrets = ligneDePrets;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }
}
