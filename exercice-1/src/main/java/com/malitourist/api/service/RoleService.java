package com.malitourist.api.service;

import com.malitourist.api.modele.Roles;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    Roles ajouterRole(Roles role);
    List<Roles> lister();
    void supprimerRole(Long id);
    Roles recuperRole(String nom);
}
