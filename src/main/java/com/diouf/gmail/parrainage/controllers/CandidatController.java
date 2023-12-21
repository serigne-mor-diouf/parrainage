package com.diouf.gmail.parrainage.controllers;

import java.util.List;

import com.diouf.gmail.parrainage.dto.CandidatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.diouf.gmail.parrainage.entites.Candidat;
import com.diouf.gmail.parrainage.services.CandidatService;

@RestController
@RequestMapping("/api/candidats")
public class CandidatController {
    @Autowired
    private CandidatService  candidatService ;

    @GetMapping
    public List<Candidat> geCandidats(){
        return candidatService.getCandidat() ;
    }


    @GetMapping("/{id}")
    public Candidat findCandidat( @PathVariable Long id ){
        return candidatService.findCandidat(id);
    }

    @PutMapping("/{id}")
    public void modifierCandidat(@PathVariable Long id , @RequestBody CandidatDTO candidat){
        candidatService.editerCandidat(id ,candidat);
    }

    @DeleteMapping("/{id}")
    public void deleteCandiadt(@PathVariable long id){
        candidatService.deleteCandiadt(id);
    }


}
