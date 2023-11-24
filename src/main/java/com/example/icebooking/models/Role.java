package com.example.icebooking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="role")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Role implements Serializable {
    @Id
    private Integer id;
    @Column(name="titre")
    private String titre;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Utilisateur> utilisateurs;
}
