package com.malitourist.api.service;

import com.malitourist.api.modele.Commentaire;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentaireService {
    List<Commentaire> listesCommentaire();
    Commentaire ajouterCommentaire(Commentaire commentaire);
    List<Commentaire> commentaireParRegion(Long id);
    void   supprimerCommentaire(Long id);
}
