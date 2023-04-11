package com.malitourist.api.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity@AllArgsConstructor@NoArgsConstructor
@Data
public class DomaineAct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 25)
    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "domaineAct")
    List<Region> regions;

}
