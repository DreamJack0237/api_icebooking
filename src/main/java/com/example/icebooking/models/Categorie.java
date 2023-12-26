package com.example.icebooking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Categorie {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nom")
    private String nom;
    @Column(name="couleur")
    private String couleur;


    @ManyToMany(mappedBy = "categories",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Ouvrage> ouvrages;
}
