package com.malitourist.api.controleur;

import com.malitourist.api.modele.Roles;
import com.malitourist.api.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class RoleControleur {
    @Autowired
    private RoleService roleService;

    @PostMapping("/ajouter")
    Roles ajouterRole(@RequestBody Roles role){
        return roleService.ajouterRole(role);
    };

    @GetMapping("/lire")
    List<Roles> lister(){
        return roleService.lister();
    };

    @DeleteMapping("/supprimer/{id}")
    void supprimerRole(@PathVariable Long id){
        roleService.supprimerRole(id);
    };
}
