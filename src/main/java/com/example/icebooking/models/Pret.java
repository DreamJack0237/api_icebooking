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
@Table(name = "Pret")
@Data
public class Pret implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "date_pret")
    private Date date_pret;
    @Column(name = "date_limite_retour")
    private Date date_limite_retour;

    @ManyToOne
    @JoinColumn(name = "demandeDePret")
    private DemandeDePret demandeDePret;

}
