package com.example.icebooking.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ligneDePret")
@Data
public class LigneDePret implements Serializable {
    @EmbeddedId
    private LigneDePretKey id;
    @Column(name = "quantite")
    private Integer quantite;

    @ManyToOne()
    @MapsId("demandePretId")
    @JoinColumn(name = "demandeDePret_Id")
    private DemandeDePret demandeDePret;

    @ManyToOne()
    @MapsId("ouvrageId")
    @JoinColumn(name = "ouvrage_Id")
    private Ouvrage ouvrage;
}
