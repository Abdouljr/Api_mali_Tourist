package com.malitourist.api.modele;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.awt.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 50)
	private String nom;
	@Column(length = 10)
	private String codeRegion;
	@Column(length = 50)
	private String superficie;
	private String image;
	@Lob
	private String description;

	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne
	private Pays pays;
	@JsonIgnore
	@OneToMany(mappedBy = "region")
	List<Commentaire> commentaires;


	@ManyToOne
	private DomaineAct domaineAct;

	@ManyToOne
	private LangueMajoritaire langueMajoritaire;

}
