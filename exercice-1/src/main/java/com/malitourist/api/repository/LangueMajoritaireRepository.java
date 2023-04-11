package com.malitourist.api.repository;

import com.malitourist.api.modele.LangueMajoritaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LangueMajoritaireRepository extends JpaRepository<LangueMajoritaire, Long> {

    public LangueMajoritaire findByNom(String nom);
}
