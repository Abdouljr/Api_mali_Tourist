package com.malitourist.api.serviceImplement;

import com.malitourist.api.modele.Roles;
import com.malitourist.api.repository.RoleRepository;
import com.malitourist.api.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Roles ajouterRole(Roles role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Roles> lister() {
        return roleRepository.findAll();
    }

    @Override
    public void supprimerRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Roles recuperRole(String nom) {
        return roleRepository.findByRole(nom);
    }
}
