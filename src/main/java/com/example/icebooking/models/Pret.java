package com.example.icebooking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Pret")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pret implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(name="date_pret")
    private Date date_pret;
    @Column(name="date_limite_retour")
    private Date date_limite_retour;

    @ManyToOne
    @JoinColumn(name = "demandeDePret")
    private DemandeDePret demandeDePret;

}
