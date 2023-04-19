package com.malitourist.api.repository;

import com.malitourist.api.modele.Pays;
import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.malitourist.api.modele.Region;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long>{

    @Query(value="SELECT nom,code_region,superficie,image FROM Region",nativeQuery = true)
    List<Object[]> sansPays();

    @Query(value = "SELECT * FROM Region", nativeQuery = true)
    List<Region> avecPays();

    @Query(value="SELECT Pays.nom,Region.nom as n,code_region,Population.nombre,superficie FROM Region,Pays,Population where Pays.id=Region.pays_id and Population.region_id=Region.id",nativeQuery = true)
    Iterable<Object[]> togetall();

    public Region findByNom(String nom);
}

