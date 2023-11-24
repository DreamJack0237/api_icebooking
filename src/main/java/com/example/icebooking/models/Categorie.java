package com.example.icebooking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Categorie {
    @Id

    private Integer id;
    @Column(name="nom_categorie")
    private String nom_categorie;
    @Column(name="couleur")
    private String couleur;


    @ManyToMany(mappedBy = "categories",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Ouvrage> ouvrages;
}
