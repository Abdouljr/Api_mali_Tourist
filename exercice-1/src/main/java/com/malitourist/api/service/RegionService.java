package com.malitourist.api.service;

import java.util.ArrayList;

import com.malitourist.api.modele.Region;

import antlr.collections.List;
import org.springframework.stereotype.Service;

@Service
public interface RegionService {
	Region creer(Region region);
	ArrayList<Region> lire();
	Region modifier (Long id, Region region);
	String suprimer (Long id);

	Iterable<Object[]> afficherSansPays();

	Iterable<Object[]> afficherAvecPays();

	Iterable<Object[]> togetall();

	Region sss(String nom);
}