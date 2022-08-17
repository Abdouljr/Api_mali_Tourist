package com.malitourist.api.controleur;

import com.malitourist.api.modele.Population;
import com.malitourist.api.service.PopulationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
@AllArgsConstructor
@Api(value= "Bonjour", description= "Exemple d'api pour une application de Gestion de Population")
public class PopulationControleur {
    @Autowired
    private PopulationService populationService;

    @PostMapping("/creer")
    @ApiOperation(value= "Pour créer une population !")
    public Population creer(@RequestBody Population population) {
        return populationService.creer(population);
    }

    @ApiOperation(value= "Pour afficher les populations")
    @GetMapping("/lire")
    public ArrayList<Population> Population(){

        return populationService.lire();
    }

    @ApiOperation(value= "Pour modifier une population")
    @PutMapping("/modifier/{id}")
    public Population modifier(@PathVariable Long id, @RequestBody Population population){
        return populationService.modifier(id, population);
    }

    @ApiOperation(value= "Pour supprimer Une Population")
    @DeleteMapping("/supprimer/{id}")
    public String supprimer(Long id){
        return populationService.supprimer(id);
    }
}
