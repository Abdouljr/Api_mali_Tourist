package com.malitourist.api.controleur;

import com.malitourist.api.modele.LangueMajoritaire;
import com.malitourist.api.service.LangueMajoritaireService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/langueMajoritaire")
@Data
public class LangueMajoritaireController {
    @Autowired
    private LangueMajoritaireService langueMajoritaireService;

    @GetMapping("/lire")
    public List<LangueMajoritaire> listeLangueMajoritaire(){
        return langueMajoritaireService.lire();
    }

    @PostMapping("/ajouter")
    public LangueMajoritaire ajouterLangueMajoritaire(@RequestBody LangueMajoritaire langueMajoritaire){
        return langueMajoritaireService.creer(langueMajoritaire);
    }

    @PutMapping("/modifier")
    public LangueMajoritaire modifierLangueMajoritaire(@RequestBody LangueMajoritaire langueMajoritaire){
        return langueMajoritaireService.modifier(langueMajoritaire.getId(), langueMajoritaire);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimerLangueMajoritaire(@PathVariable Long id){
        return langueMajoritaireService.supprimer(id);
    }
}
