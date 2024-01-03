package com.example.icebooking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="telechargement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Telechargement implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(name="date_telecharger=ment")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "ouvrqge_id")
    private Ouvrage ouvrage;
}
