package com.malitourist.api.repository;

import com.malitourist.api.modele.DomaineAct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomaineActRepository extends JpaRepository<DomaineAct, Long> {
    public DomaineAct findByNom(String nom);
}
