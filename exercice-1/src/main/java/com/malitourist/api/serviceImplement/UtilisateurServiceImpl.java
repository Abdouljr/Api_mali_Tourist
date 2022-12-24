package com.malitourist.api.serviceImplement;

import com.malitourist.api.modele.Roles;
import com.malitourist.api.modele.Utilisateur;
import com.malitourist.api.repository.RoleRepository;
import com.malitourist.api.repository.UtilisateurRepository;
import com.malitourist.api.service.UtilisateurService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Data
@Component
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Utilisateur recuperUtilisateur(String utilisateur) {
        return utilisateurRepository.findByUsername(utilisateur);
    }

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        String mdp = utilisateur.getPassword();
        utilisateur.setPassword(passwordEncoder.encode(mdp));
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public List<Utilisateur> afficherUtilisateur() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur modifierUtilisateur(Long id, Utilisateur utilisateur) {
        return utilisateurRepository.findById(id).map(u -> {
            u.setUsername(utilisateur.getUsername());
            u.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
            u.setEmail(utilisateur.getEmail());
            return utilisateurRepository.save(u);
        }).orElseThrow(() -> new RuntimeException("Cet utilisateur n'existe pas !"));
    }

    @Override
    public void ajouterRoleUtilisateur(String nomRole, String nomUtilisateur) {
        Roles role = roleRepository.findByRole(nomRole);
        Utilisateur utilisateur = utilisateurRepository.findByUsername(nomUtilisateur);
        utilisateur.getRoles().add(role);
        utilisateurRepository.save(utilisateur);
    }

    @Override
    public void supprimerUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
