package com.example.icebooking.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class LigneDePretKey implements Serializable {


    private static final long seriaVersionUID=-7275079172834495436L;


    @Column(name="demandeDePreDet_Id")
    private Integer demandePretId;

    @Column(name="ouvrage_Id")
    private Integer ouvrageId;
}
