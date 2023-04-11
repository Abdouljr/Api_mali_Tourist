package com.malitourist.api.serviceImplement;

import com.malitourist.api.modele.Pays;
import com.malitourist.api.repository.PaysRepository;
import com.malitourist.api.service.PaysService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Data
@Component
public class PaysServiceImpl implements PaysService {
    private final PaysRepository paysRepository;

    @Override
    public Pays creer(Pays pays) {
        return paysRepository.save(pays);
    }

    @Override
    public List<Pays> lire() {
        return paysRepository.findAll();
    }

    @Override
    public Pays modifier(Long id, Pays pays) {
        return paysRepository.findById(id)
                .map(p -> {
                    p.setNom(pays.getNom());
                    p.setDescription(pays.getDescription());
                    return paysRepository.save(p);
                } ).orElseThrow(()-> new RuntimeException("Ce pays n'existe pas !"));
    }

    @Override
    public String supprimer(Long id) {
        paysRepository.findById(id).orElseThrow(()-> new RuntimeException("Ce pays n'existe pas !"));
        paysRepository.deleteById(id);
        return "Le pays a été supprimer avec succé !";
    }

    @Override
    public Pays existePays(String nom) {
        return paysRepository.findByNom(nom);
    }

    @Override
    public void upload(MultipartFile file) throws IOException {
        file.transferTo(new File("C:\\Users\\USER\\Desktop\\Ionic\\MaliTourist\\src\\assets\\"+file.getOriginalFilename()));
    }
}
