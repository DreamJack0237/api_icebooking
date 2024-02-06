package com.example.icebooking.models;

import com.example.icebooking.TypeDeRole;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(name="titre")
    @Enumerated(EnumType.STRING)
    private TypeDeRole titre;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Utilisateur> utilisateurs;
}
