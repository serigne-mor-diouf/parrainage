package com.diouf.gmail.parrainage.controllers;

import com.diouf.gmail.parrainage.dto.DelegueDTO;
import com.diouf.gmail.parrainage.services.DelegueRegionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.diouf.gmail.parrainage.dto.CandidatDTO;
import com.diouf.gmail.parrainage.dto.CollecteurDTO;
import com.diouf.gmail.parrainage.dto.ParrainageDTO;
import com.diouf.gmail.parrainage.entites.Utilisateur;
import com.diouf.gmail.parrainage.services.CandidatService;
import com.diouf.gmail.parrainage.services.CollecteurService;
import com.diouf.gmail.parrainage.services.ParrainageService;

@RestController
@RequestMapping("/inscription")
public class UserController {
    

    @Autowired
    private ParrainageService parrainageService;

    @Autowired
    private CandidatService candidatService ;

    @Autowired
    private CollecteurService  collecteurService ;

    @Autowired
    private DelegueRegionalService delegueRegionalService ;


    @PostMapping("/parrainage")
   // @CrossOrigin("http://localhost:4200/")
    public ResponseEntity<?> addParrainsParrainage(@RequestBody ParrainageDTO parrainageDTO) {
        System.out.print("enregistrement de parrainDto ");
        Utilisateur  parrainage = parrainageService.addParrainsParrainage(parrainageDTO) ;
        if (parrainage != null) {
           return ResponseEntity.status(HttpStatus.CREATED).body(parrainage.getId());
          }
          else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
          }
    }

    
    @PostMapping("/candidat")
    public  ResponseEntity<?> addCandidat(@RequestBody CandidatDTO candidatDTO){
       System.out.print("enregistrement de parrainDto ");
       Utilisateur candidat = candidatService.addCandidat(candidatDTO);
       if (candidat != null) {

        return ResponseEntity.status(HttpStatus.CREATED).body(candidat.getId());
          }
          else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
          }
     }

      @PostMapping("/collecteur")
     public ResponseEntity<?> addCollecteur(@RequestBody CollecteurDTO collecteurDTO){
      System.out.print("enregistrement de collecteurDTO ");
      Utilisateur collecteur = collecteurService.addCollecteur(collecteurDTO) ;
      if (collecteur != null) {
      
        return ResponseEntity.status(HttpStatus.CREATED).body(collecteur.getId());
          }
          else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

          }
     }
     @PostMapping("/deleguer")
     public ResponseEntity<?> addDeleguer(@RequestBody DelegueDTO delegueDTO){
      System.out.print("enregistrement de collecteurDTO ");
      Utilisateur delegue = delegueRegionalService.addDelegueRegional(delegueDTO) ;
      if (delegue != null) {

        return ResponseEntity.status(HttpStatus.CREATED).body(delegue.getId());
          }
          else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
          }
     }
}
