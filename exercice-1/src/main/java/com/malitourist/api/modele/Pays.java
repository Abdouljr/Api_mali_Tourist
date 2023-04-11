package com.malitourist.api.modele;

import lombok.*;

import javax.persistence.*;


@Entity
@Data@AllArgsConstructor@NoArgsConstructor
public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50)
    private String nom;
    @Lob
    private String description;

}


