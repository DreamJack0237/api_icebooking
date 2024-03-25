package com.example.icebooking.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "pret")
@Data
public class Pret implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @CreationTimestamp
    @Column(name = "date_pret")
    @JsonProperty("loaned_at")
    private Date loanDate;

    @Column(name = "limit_back_date")
    private Date limitBackDate;

    @Column(name = "back_date", nullable = true)
    private Date BackDate;

    @ManyToMany
    @JoinTable(name = "pret_ouvrage", joinColumns = @JoinColumn(name = "pret_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Ouvrage> ouvrages;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = true)
    private Utilisateur utilisateur;

    public void addBook(Ouvrage book) {
        ouvrages.add(book);
    }

}
