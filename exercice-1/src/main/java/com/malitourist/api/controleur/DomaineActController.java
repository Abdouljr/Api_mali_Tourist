package com.malitourist.api.controleur;

import com.malitourist.api.modele.DomaineAct;
import com.malitourist.api.service.DomaineActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/domaineAct")
public class DomaineActController {
    @Autowired
    private DomaineActService domaineActService;

    @GetMapping("/lire")
    public List<DomaineAct> listeDomaineAct(){
        return domaineActService.lire();
    }

    @PostMapping("/ajouter")
    public DomaineAct ajouterDomaineAct(@RequestBody DomaineAct domaineAct){
        return domaineActService.creer(domaineAct);
    }

    @PutMapping("/modifier")
    public DomaineAct modifierDomaineAct(@RequestBody DomaineAct domaineAct){
        return domaineActService.modifier(domaineAct.getId(), domaineAct);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimerDomaineAct(@PathVariable Long id){
        return domaineActService.supprimer(id);
    }
}
