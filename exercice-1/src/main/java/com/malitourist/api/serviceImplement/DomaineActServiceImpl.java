package com.malitourist.api.serviceImplement;

import com.malitourist.api.modele.DomaineAct;
import com.malitourist.api.repository.DomaineActRepository;
import com.malitourist.api.service.DomaineActService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Data
@Component
public class DomaineActServiceImpl implements DomaineActService {

    @Autowired
    private DomaineActRepository domaineActRepository;

    @Override
    public DomaineAct creer(DomaineAct domaineAct) {
        DomaineAct domaine = domaineActRepository.findByNom(domaineAct.getNom());
        if(domaine != null){
            throw new RuntimeException("Cette langue majoritaire existe déjà !");
        }
        return domaineActRepository.save(domaineAct);
    }

    @Override
    public List<DomaineAct> lire() {
        return domaineActRepository.findAll();
    }

    @Override
    public DomaineAct modifier(Long id, DomaineAct domaineAct) {
        return domaineActRepository.findById(id)
                .map(p -> {
                    p.setNom(domaineAct.getNom());
                    return domaineActRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Cette langue majoritaire n'existe pas !"));
    }

    @Override
    public String supprimer(Long id) {
        Optional<DomaineAct> domaineAct = domaineActRepository.findById(id);
        if (domaineAct.isPresent()){
            domaineActRepository.deleteById(id);
            return   "La suppression de " + domaineAct.get().getNom() + " a été faite avec succée !";
        }else {
            return "La suppression a échoué !";
        }
    }


}
