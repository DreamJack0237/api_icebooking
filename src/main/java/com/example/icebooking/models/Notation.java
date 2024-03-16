package com.example.icebooking.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Avis")
@Data
public class Notation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "valeur")
    private String valeur;
    @Column(name = "date_avis")
    private Date date_avis;
    @Column(name = "date_mise_ajour")
    private Date date_mise_ajour;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Utilisateur owner;

    @ManyToOne
    @JoinColumn(name = "ouvrage_id")
    private Ouvrage ouvrage;
}
