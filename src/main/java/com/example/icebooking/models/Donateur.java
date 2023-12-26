package com.example.icebooking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="donateur")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Donateur implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nom")
    private String nom;
    @Column(name="numero_tel")
    private double telephone;

    @OneToMany(mappedBy = "donateur",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Don> dons;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;



}
