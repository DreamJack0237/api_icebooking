package com.example.icebooking.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;

@Entity
@Table(name="validation")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Validation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    private Instant creation;
    private Instant activation;
    private Instant expiration;
    private String code;
    @OneToOne(cascade = CascadeType.ALL)
    private Utilisateur utilisateur;
}
