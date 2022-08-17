package com.malitourist.api.service;

import com.malitourist.api.modele.Pays;
import com.malitourist.api.repository.PaysRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Data
@Component
public class PaysServiceImpl implements PaysService{
    private final PaysRepository paysRepository;

    @Override
    public Pays creer(Pays pays) {
        return paysRepository.save(pays);
    }

    @Override
    public List<Pays> lire() {
        return paysRepository.findAll();
    }

    @Override
    public Pays modifier(Long id, Pays pays) {
        return paysRepository.findById(id)
                .map(p -> {
                    p.setNom(pays.getNom());
                    return paysRepository.save(p);
                } ).orElseThrow(()-> new RuntimeException("Ce pays n'existe pas !"));
    }

    @Override
    public String supprimer(Long id) {
        paysRepository.deleteById(id);
        return "Le pays a été supprimer avec succé !";
    }

    @Override
    public Pays existePays(String nom) {
        return paysRepository.findByNom(nom);
    }
}
