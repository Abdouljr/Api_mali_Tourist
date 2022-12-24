package com.malitourist.api.serviceImplement;

import com.malitourist.api.modele.Population;
import com.malitourist.api.repository.PopulationRepository;
import com.malitourist.api.service.PopulationService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Data
@Component
@AllArgsConstructor
public class PopulationServiceImpl implements PopulationService {
    private final PopulationRepository populationRepository;

    @Override
    public Population creer(Population population) {
        return populationRepository.save(population);
    }

    @Override
    public ArrayList<Population> lire() {
        return (ArrayList<Population>) populationRepository.findAll();
    }

    @Override
    public Population modifier(Long id, Population population) {
        return populationRepository.findById(id)
                .map(p ->{
                    p.setNombre(population.getNombre());
                    p.setDate(population.getDate());
                    return populationRepository.save(p);
        }).orElseThrow(()-> new RuntimeException("Cette population n'existe pas !"));
    }

    @Override
    public String supprimer(Long id) {
        populationRepository.deleteById(id);
        return "La suppréssion a été faite avec succée !";
    }
}
