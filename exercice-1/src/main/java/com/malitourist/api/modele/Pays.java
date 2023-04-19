package com.malitourist.api.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


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

    @JsonIgnore
    @OneToMany(mappedBy = "pays")
    List<Population> populations;

}


