package com.malitourist.api.service;

import com.malitourist.api.modele.Pays;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaysService {
    Pays creer(Pays pays);
    List<Pays> lire();

    Pays modifier (Long id, Pays pays);

    String supprimer (Long id);

    Pays existePays(String nom);
}
