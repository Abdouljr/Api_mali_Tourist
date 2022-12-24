package com.malitourist.api.service;

import com.malitourist.api.modele.Pays;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface PaysService {
    Pays creer(Pays pays);
    List<Pays> lire();

    Pays modifier (Long id, Pays pays);

    String supprimer (Long id);

    Pays existePays(String nom);

    void upload(MultipartFile file) throws IOException;

}
