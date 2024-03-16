package com.example.icebooking.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "donateur")
@Data

public class Donator implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "numero_tel")
    private double telephone;

    @OneToMany(mappedBy = "donateur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Donation> dons;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

}
