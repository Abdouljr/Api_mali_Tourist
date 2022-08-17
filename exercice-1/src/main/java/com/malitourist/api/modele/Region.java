package com.malitourist.api.modele;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="Region")
@Getter
@Setter
@NoArgsConstructor
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 50)
	private String nom;
	@Column(length = 10)
	private String codeRegion;
	@Column(length = 50)
	private String domaineAct;
	@Column(length = 50)
	private String superficie;
	@Column(length = 50)
	private String langueMajoritaire;


	@ManyToOne
	@JoinColumn(name = "pays_id")
	private Pays pays;

}
