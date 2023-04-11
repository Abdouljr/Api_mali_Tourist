package com.malitourist.api.serviceImplement;

import com.malitourist.api.modele.LangueMajoritaire;
import com.malitourist.api.repository.LangueMajoritaireRepository;
import com.malitourist.api.service.LangueMajoritaireService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Data
@Component
public class LangueMajoritaireServiceImpl implements LangueMajoritaireService {
    @Autowired
    private LangueMajoritaireRepository langueMajoritaireRepository;

    @Override
    public LangueMajoritaire creer(LangueMajoritaire langueMajoritaire) {
        return langueMajoritaireRepository.save(langueMajoritaire);
    }

    @Override
    public List<LangueMajoritaire> lire() {
        return langueMajoritaireRepository.findAll();
    }

    @Override
    public LangueMajoritaire modifier(Long id, LangueMajoritaire langueMajoritaire) {
        return langueMajoritaireRepository.findById(id)
                .map(p -> {
                    p.setNom(langueMajoritaire.getNom());
                    return langueMajoritaireRepository.save(p);
        }).orElseThrow(()-> new RuntimeException("Cette langue majoritaire n'existe pas !"));
    }

    @Override
    public String supprimer(Long id) {

            Optional<LangueMajoritaire> langue = langueMajoritaireRepository.findById(id);
            if (langue.isPresent()){
            langueMajoritaireRepository.deleteById(id);
              return   "La suppression de la langue " + langue.get().getNom() + " a été faite avec succée !";
            }else {

            return "La suppression a échoué !";
            }


    }

    @Override
    public LangueMajoritaire existeLangueMajoritaire(String nom) {
        return langueMajoritaireRepository.findByNom(nom);
    }
}
