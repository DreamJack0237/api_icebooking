package com.example.icebooking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="don")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class Don implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="date")
    private Date date  ;
    @ManyToOne
    @JoinColumn(name = "donateur_id")
    private Donateur donateur;
}
