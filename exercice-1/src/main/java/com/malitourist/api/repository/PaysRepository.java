package com.malitourist.api.repository;

import com.malitourist.api.modele.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysRepository extends JpaRepository<Pays, Long> {

    public Pays findByNom(String nom);
}
