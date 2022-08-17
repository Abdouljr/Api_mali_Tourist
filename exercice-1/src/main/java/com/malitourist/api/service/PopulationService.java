package com.malitourist.api.service;

import com.malitourist.api.modele.Population;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface PopulationService {
    public Population creer(Population population);
    ArrayList<Population> lire();

    Population modifier (Long id, Population population);

    String supprimer (Long id);
}
