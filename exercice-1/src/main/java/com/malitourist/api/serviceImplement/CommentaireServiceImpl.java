package com.malitourist.api.serviceImplement;

import com.malitourist.api.modele.Commentaire;
import com.malitourist.api.repository.CommentaireRepository;
import com.malitourist.api.service.CommentaireService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CommentaireServiceImpl implements CommentaireService {
    @Autowired
    public CommentaireRepository commentaireRepository;
    @Override
    public List<Commentaire> listesCommentaire() {
        return commentaireRepository.findAll();
    }

    @Override
    public Commentaire ajouterCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public List<Commentaire> commentaireParRegion(Long id) {
        System.out.println("------------------------    " + id  +"  ---------------------------");
        return commentaireRepository.commentaireByRegion(id);
    }

    @Override
    public void supprimerCommentaire(Long id) {
        commentaireRepository.deleteById(id);

    }
}
