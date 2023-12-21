package com.diouf.gmail.parrainage.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.diouf.gmail.parrainage.dto.ParrainageDTO;
import com.diouf.gmail.parrainage.entites.Parrainage;
import com.diouf.gmail.parrainage.services.ParrainageService;

@RestController
@RequestMapping("/api/parrainages")
public class ParrainageController {

    @Autowired
    private ParrainageService parrainageService;

    @GetMapping
    public List<Parrainage> getParrainage() {
        return parrainageService.getParrainage();
    }

    @DeleteMapping("/{numero}")
    public void deleteParrainage(@PathVariable Long numero) {
        parrainageService.deletePArrainage(numero);
    }

    @GetMapping("/{numero}")
    public Parrainage findParrainage(@PathVariable Long numero) {
        return parrainageService.findParrainage(numero);
    }

   // Décommentez et gérez correctement la méthode modifierParrainage si nécessaire.
    @PutMapping("/{id}")
    public void modifierParrainage(@PathVariable Long id , ParrainageDTO parrainageDTO){
        parrainageService.modifierParrainage(id ,parrainageDTO);
    }
    

}
