package com.malitourist.api.serviceImplement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import com.malitourist.api.service.RegionService;
import org.springframework.stereotype.Component;

import com.malitourist.api.modele.Region;
import com.malitourist.api.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Component
@AllArgsConstructor
public class RegionServiceImpl implements RegionService {
	
	private final RegionRepository regionRepository;
	
	@Override
	public Region creer(Region region) {

		return regionRepository.save(region);
	}

	@Override
	public ArrayList<Region> lire() {
		return (ArrayList<Region>) regionRepository.findAll();
	}


	@Override
	public String suprimer(Long id) {
		regionRepository.deleteById(id);
		return " Suppression effectuée avec succé! ";
	}

	@Override
	public Iterable<Object[]> afficherSansPays() {
		return regionRepository.sansPays();
	}

	@Override
	public Iterable<Object[]> afficherAvecPays() {
		return regionRepository.avecPays();
	}

	@Override
	public Iterable<Object[]> togetall() {
		return regionRepository.togetall();

	}

	@Override
	public Optional<Region> regionParSonId(Long id) {
		 Optional<Region> region = regionRepository.findById(id);
		 if (region.isEmpty()){
			 return Optional.empty();
		 }else {
			 return region;
		 }
	}

	@Override
	public void upload(MultipartFile file) throws IOException {
		file.transferTo(new File("C:\\Users\\USER\\Desktop\\Ionic\\MaliTourist\\src\\assets\\"+file.getOriginalFilename()));
	}

	@Override
	public Region sss(String nom) {
		return regionRepository.findByNom(nom);
	}


	@Override
	public Region modifier(Long id, Region region) {
		// TODO Auto-generated method stub
		return regionRepository.findById(id)
				.map(p ->{
					p.setNom(region.getNom());
					p.setCodeRegion(region.getCodeRegion());
					p.setDomaineAct(region.getDomaineAct());
					p.setSuperficie(region.getSuperficie());
					p.setLangueMajoritaire(region.getLangueMajoritaire());
					return regionRepository.save(p);
				}).orElseThrow(() -> new RuntimeException(" La Region n'existe pas !"));
	}

}
