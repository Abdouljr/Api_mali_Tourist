package com.malitourist.api.controleur;

import java.util.ArrayList;

import com.malitourist.api.modele.Pays;
import com.malitourist.api.modele.Population;
import com.malitourist.api.service.PaysService;
import com.malitourist.api.service.PopulationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malitourist.api.modele.Region;
import com.malitourist.api.service.RegionService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/region")
@AllArgsConstructor
@Api(value= "Bonjour", description= "Exemple d'api d'une application pour la gestion des Régions")
public class RegionControleur {

	@Autowired
	private  RegionService regionService;
	@Autowired
	private  PopulationService populationService;
	@ApiOperation(value= "Pour créer des Régions")
	@PostMapping("/creer")
	public Object creer(@RequestBody Region region) {
		 if(regionService.sss(region.getNom()) != null){
			 return "Cette region existe déjà !";
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
	@PutMapping("/modifier/{id}") //Path variable
	public  Region modifier(@PathVariable Long id, @RequestBody Region region) {
		return regionService.modifier(id, region);
	}

	@ApiOperation(value= "Pour supprimer une Région")
	@DeleteMapping("/supprimer/{id}")
	public String suprimer(@PathVariable Long id) {
		regionService.suprimer(id);
		return "Region supprime avec succée !";
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



















