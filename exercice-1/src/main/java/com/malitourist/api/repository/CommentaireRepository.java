package com.malitourist.api.repository;

import com.malitourist.api.modele.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
    @Query(value="SELECT * FROM commentaire WHERE region_id =:id",nativeQuery = true)
    public List<Commentaire> commentaireByRegion(Long id);

}
