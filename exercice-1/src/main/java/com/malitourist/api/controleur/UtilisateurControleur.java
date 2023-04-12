package com.malitourist.api.controleur;

import com.malitourist.api.modele.Utilisateur;
import com.malitourist.api.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utilisateur")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class UtilisateurControleur {
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/lire/{utilisateur}")
    public Utilisateur recuperUtilisateur(@PathVariable String utilisateur){
        return utilisateurService.recuperUtilisateur(utilisateur);
    };
    @PostMapping("/ajouter")
    public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurService.ajouterUtilisateur(utilisateur);
    };

    @PostMapping("/ajouterrole/{nomUtilisateur}/{nomRole}")
    void ajouterRoleUtilisateur(@PathVariable String nomUtilisateur, @PathVariable String nomRole){
         utilisateurService.ajouterRoleUtilisateur(nomRole, nomUtilisateur);
    };

    @GetMapping("/liretous")
    public List<Utilisateur> afficherUtilisateur(){
        return utilisateurService.afficherUtilisateur();
    };

    @PutMapping("/modifier")
    public Utilisateur modifierUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurService.modifierUtilisateur(utilisateur);
    };

    @DeleteMapping("/supprimer/{id}")
    public void  supprimerUtilisateur(@PathVariable Long id){
        utilisateurService.supprimerUtilisateur(id);
    };
}
