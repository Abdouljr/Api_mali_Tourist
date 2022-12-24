package com.malitourist.api.controleur;

import com.malitourist.api.modele.Commentaire;
import com.malitourist.api.service.CommentaireService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commentaire")
@CrossOrigin(origins = "*")
@Data
public class CommentaireController {
    @Autowired
    public CommentaireService commentaireService;

    @GetMapping("/lire")
    public List<Commentaire> listeCommentaires(){
        return commentaireService.listesCommentaire();
    }

    @PostMapping("/ajouter")
    public Commentaire ajouterCommentaire(@RequestBody Commentaire commentaire){
        return commentaireService.ajouterCommentaire(commentaire);
    }

    @GetMapping("/region/{id}")
    public List<Commentaire> commentaireListes(@PathVariable Long id){
        return commentaireService.commentaireParRegion(id);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimerCommentaire(@PathVariable Long id){
        commentaireService.supprimerCommentaire(id);
        return "Supprimer avec succé";
    }
}
