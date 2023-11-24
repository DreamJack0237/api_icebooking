package com.example.icebooking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@Entity
@Table(name="ligneDePret")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LigneDePret implements Serializable {
    @EmbeddedId
    private LigneDePretKey id;
    @Column(name="quantite")
    private Integer quantite;

    @ManyToOne()
    @MapsId("demandePretId")
    @JoinColumn(name="demandeDePret_Id")
    private DemandeDePret demandeDePret;

    @ManyToOne()
    @MapsId("ouvrageId")
    @JoinColumn(name="ouvrage_Id")
    private Ouvrage ouvrage;
}
