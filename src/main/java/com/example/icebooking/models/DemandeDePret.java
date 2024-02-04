package com.example.icebooking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="demandeDePret")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class DemandeDePret implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(name="date_debut")
    private Date date_debut;
    @Column(name="date_fin")
    private Date date_fin;
    @Column(name="date_demande")
    private Date date_demande;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;


    @OneToMany(mappedBy = "demandeDePret",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<LigneDePret> ligneDePrets;

    @OneToMany(mappedBy = "demandeDePret",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List <Pret> prets;
}
