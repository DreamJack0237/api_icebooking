package com.example.icebooking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Avis")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Avis implements Serializable {
    @Id
    private Integer id;
    @Column(name="valeur")
    private String valeur;
    @Column(name="date_avis")
    private Date date_avis;
    @Column(name="date_mise_ajour")
    private Date date_mise_ajour;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "ouvrqge_id")
    private Ouvrage ouvrage;
}
