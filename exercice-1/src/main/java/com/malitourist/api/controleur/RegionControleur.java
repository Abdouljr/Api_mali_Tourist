package com.malitourist.api.controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import com.malitourist.api.modele.Population;
import com.malitourist.api.repository.RegionRepository;
import com.malitourist.api.service.PaysService;
import com.malitourist.api.service.PopulationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.malitourist.api.modele.Region;
import com.malitourist.api.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/region")
@AllArgsConstructor
@CrossOrigin(origins = "*")
@Api(value= "Bonjour", description= "Exemple d'api d'une application pour la gestion des Régions")
public class RegionControleur {

	@Autowired
	private  RegionService regionService;
	@Autowired
	private PaysService paysService;
	@Autowired
	private  PopulationService populationService;
	private final RegionRepository regionRepository;

	@ApiOperation(value= "Pour créer des Régions")
	@PostMapping("/ajouter")
	public Region creer(@RequestBody Region region){
		Region regionExiste = regionRepository.findByNom(region.getNom());
		 if(regionExiste != null){
			 throw new RuntimeException("Cette Region existe déjà !");
		 }else {
			   return regionService.creer(region);
		 }
	}




	@ApiOperation(value= "Pour afficher les Régions")
	@GetMapping("/lire")
	public ArrayList<Region> lire(){

		return regionService.lire();
	}

	@ApiOperation(value= "Pour modifier une Région")
	@PutMapping("/modifier") //Path variable
	public  Region modifier(@RequestBody Region region) {
		return regionService.modifier(region.getId(), region);
	}

	@ApiOperation(value= "Pour supprimer une Région")
	@DeleteMapping("/supprimer/{id}")
	public String suprimer(@PathVariable Long id) {
		regionService.suprimer(id);
		return "Region supprime avec succée !";
	}

	@GetMapping("/{id}")
	public Optional<Region> regionParSonId(@PathVariable Long id){
		return regionService.regionParSonId(id);
	}

	@GetMapping("/afficherAvecPays")
	Iterable<Object[]> afficher(){
		return regionService.afficherAvecPays();
	}


	@ApiOperation(value= "Pour afficher tous les éléments de Région")
	@GetMapping("/afficherSansPays")
	Iterable<Object[]> afficherSansPays(){
		return regionService.afficherSansPays();
	}
	@GetMapping("/Tout")
	public Iterable<Object[]> togetall() {
		return regionService.togetall();

	}

	@ApiOperation(value= "Pour ajouter une Région et une Population")
	@PostMapping("/prp")
	public String method(@RequestBody Region r, @RequestBody Population p){
		regionService.creer(r);
		populationService.creer(p);
		return "L'ajout Région et Population a été fait avec succé !";
	}


}



















