package com.malitourist.api.repository;

import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.malitourist.api.modele.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long>{

    @Query(value="SELECT nom,code_region,domaine_act,superficie,langue_majoritaire FROM Region",nativeQuery = true)
    Iterable<Object[]> sansPays();

    @Query(value = "SELECT * FROM Region", nativeQuery = true)
    Iterable<Object[]> avecPays();

    @Query(value="SELECT Population.nombre,code_region,domaine_act,superficie,langue_majoritaire,Pays.nom FROM Region,Pays,Population where Pays.id=Region.pays_id and Population.region_id=Region.id",nativeQuery = true)
    Iterable<Object[]> togetall();

    public Region findByNom(String nom);
}

