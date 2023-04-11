package com.malitourist.api.service;

import com.malitourist.api.modele.DomaineAct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DomaineActService {
    DomaineAct creer(DomaineAct domaineAct);
    List<DomaineAct> lire();
    DomaineAct modifier(Long id, DomaineAct domaineAct);
    String supprimer(Long id);
}
