package com.malitourist.api.controleur;


import com.malitourist.api.modele.Pays;
import com.malitourist.api.service.PaysService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pays")
@AllArgsConstructor
@CrossOrigin(origins = "*")
@Api(value= "Bonjour", description= "Exemple d'api d'une application Pour la Gestion des pays")
public class PaysControleur {
    private final PaysService paysService;

    @ApiOperation(value= "Pour créer un pays !")
    @PostMapping("/ajouter")
    public Object creer(@RequestBody Pays pays) {
        if(paysService.existePays(pays.getNom()) != null){
            return "Ce pays existe déjà !";
        }else {
            return paysService.creer(pays);
        }
    }

    @ApiOperation(value= "Pour afficher les Pays")
    @GetMapping("/lire")
    public List<Pays> Pays(){
        return paysService.lire();
    }

    @ApiOperation(value= "Pour modifier un pays")
    @PutMapping("/modifier/{id}")
    public Pays modifier(@PathVariable Long id, @RequestBody Pays pays){
        return paysService.modifier(id, pays);
    }

    @ApiOperation(value= "Pour supprimer un pays")
    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return paysService.supprimer(id);
    }

    @PostMapping("/upload")
	public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println("--------------------------  Bonjour " + file.getOriginalFilename() + " --------------------");
		paysService.upload(file);
	}
}
