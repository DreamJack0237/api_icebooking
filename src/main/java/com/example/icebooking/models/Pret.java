package com.example.icebooking.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "pret")
@Data
public class Pret implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "date_pret")
    private Date date_pret;
    @Column(name = "date_limite_retour")
    private Date date_limite_retour;


    @Column(name = "date_retour", nullable = true)
    private Date date_retour;

    @ManyToMany
    @JoinTable(name = "pret_ouvrage", joinColumns = @JoinColumn(name = "pret_id"), inverseJoinColumns = @JoinColumn(name = "ouvrage_id"))
    private List<Ouvrage> ouvrages;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

}
