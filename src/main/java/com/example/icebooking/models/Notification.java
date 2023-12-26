package com.example.icebooking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@Entity
@Table(name="notification")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Notification implements Serializable  {
    @Id
    private Integer id;
    @Column(name="Message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
}
