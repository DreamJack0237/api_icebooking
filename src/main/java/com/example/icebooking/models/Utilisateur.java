package com.example.icebooking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="utilisateurs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private  Integer id;
    @Column(name="nom")
    private String nom;
    @Column(name="Email")
    private String Email;
    @Column(name="Password")
    private String Password;

    @OneToMany(mappedBy = "utilisateur",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Donateur> donateurs;

    @OneToMany(mappedBy = "utilisateur",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Notification> notifications;

    @ManyToOne
    @JoinColumn(name = "Role_id")
    private Role role;



    @OneToMany(mappedBy = "utilisateur",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Avis> avis;

    @OneToMany(mappedBy = "utilisateur",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Lecture> lectures;

    @OneToMany(mappedBy = "utilisateur",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Commentaire> commentaires;

    @OneToMany(mappedBy = "utilisateur",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Telechargement> telechargements;

    @OneToMany(mappedBy = "utilisateur",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Ouvrage> ouvrages;

    @OneToMany(mappedBy = "utilisateur",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<DemandeDePret> demandeDePrets;



}
