package com.diouf.gmail.parrainage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diouf.gmail.parrainage.dto.CollecteurDTO;
import com.diouf.gmail.parrainage.entites.Collecteur;
import com.diouf.gmail.parrainage.services.CollecteurService;

@RestController
@RequestMapping("/api/collecteurs")
public class CollecteurController {
    @Autowired
    private CollecteurService collecteurService ;
    
    
    @GetMapping
    public List<Collecteur> getCollecteurs() {
        return collecteurService.getCollecteurs();
    }

    @DeleteMapping("/{id}")
    public void deleteDelegue(@PathVariable Long id) {
        collecteurService.deleteCollecteur(id);
    }

    // @PostMapping
    // public Collecteur addParrainsParrainage(@RequestBody CollecteurDTO collecteur  ) {
    //     return collecteurService.addCollecteur(collecteur);
    // }

    @GetMapping("/{id}")
    public Collecteur findCollecteur(@PathVariable Long id) {
        return collecteurService.findCollecteur(id);
    }

    @PutMapping("/{id}")
    public void modifierParrainage(@PathVariable Long id , @RequestBody CollecteurDTO collecteur){
        collecteurService.modifierCollecteur(id ,collecteur);
    }
}
