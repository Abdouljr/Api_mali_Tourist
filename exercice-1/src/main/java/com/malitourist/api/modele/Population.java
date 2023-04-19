package com.malitourist.api.modele;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.util.List;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor
public class Population {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50)
    private int nombre;
    @Column(length = 10)
    private String date;

    @ManyToOne
    @JoinColumn(name = "pays_id")
    private Pays pays;

    // @JsonProperty(access = JsonProperty.Access.READ_WRITE)
   // @ManyToOne
   // @JoinColumn(name = "region_id")
   // private Region region;

}
