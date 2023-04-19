package com.malitourist.api.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.malitourist.api.modele.Region;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface RegionService {
	Region creer(Region region);
	ArrayList<Region> lire();
	Region modifier (Long id, Region region);
	String suprimer (Long id);

	List<Object[]> afficherSansPays();

	List<Region> afficherAvecPays();

	Iterable<Object[]> togetall();

	Optional<Region> regionParSonId(Long id);
	void upload(MultipartFile file) throws IOException;
}