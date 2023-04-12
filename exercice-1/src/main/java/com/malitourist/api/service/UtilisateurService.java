package com.malitourist.api.service;

import com.malitourist.api.modele.Utilisateur;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UtilisateurService {

    Utilisateur recuperUtilisateur(String utilisateur);
    Utilisateur ajouterUtilisateur(Utilisateur utilisateur);
     List<Utilisateur> afficherUtilisateur();
     Utilisateur modifierUtilisateur(Utilisateur utilisateur);

    void ajouterRoleUtilisateur(String nomRole, String nomUtilisateur);
    void  supprimerUtilisateur(Long id);
}
