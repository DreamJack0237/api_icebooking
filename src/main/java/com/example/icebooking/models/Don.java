package com.example.icebooking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="don")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Don implements Serializable {
    @Id
    private Integer id;
    @Column(name="date")
    private Date date  ;
    @ManyToOne
    @JoinColumn(name = "donateur_id")
    private Donateur donateur;
}
