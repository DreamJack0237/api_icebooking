package com.example.icebooking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Lecture")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Lecture implements Serializable {
    @Id
    private Integer id;
    @Column(name="date_lecture")
    private Date date_lecture;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "ouvrqge_id")
    private Ouvrage ouvrage;
}
