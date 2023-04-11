package com.malitourist.api.service;

import com.malitourist.api.modele.LangueMajoritaire;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LangueMajoritaireService {
    LangueMajoritaire creer(LangueMajoritaire langueMajoritaire);
    List<LangueMajoritaire> lire();
    LangueMajoritaire modifier(Long id, LangueMajoritaire langueMajoritaire);
    String supprimer(Long id);
    LangueMajoritaire existeLangueMajoritaire(String nom);
}
