package com.diouf.gmail.parrainage.services;

import java.util.List;
import java.util.Optional;

import com.diouf.gmail.parrainage.entites.Candidat;
import com.diouf.gmail.parrainage.repositories.CandidatRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.diouf.gmail.parrainage.dto.CollecteurDTO;
import com.diouf.gmail.parrainage.entites.Collecteur;
import com.diouf.gmail.parrainage.repositories.CollecteurRepository;

@Service
public class CollecteurService {
    @Autowired
    private CollecteurRepository  collecteurRepository ;

    @Autowired
    private CandidatRepository  candidatRepository ;

    public List<Collecteur>getCollecteurs(){
        return collecteurRepository.findAll();
    }


     public Collecteur addCollecteur(CollecteurDTO  collecteurDTO){
        Optional<Candidat>candidatOptional = candidatRepository.findById(collecteurDTO.getCandidat());
        if (candidatOptional.isPresent()){
            Candidat candidat = candidatOptional.get();
            Collecteur collecteur = collecteurDTO.toCollecteur();
            collecteur.setCandidat(candidat);
            collecteurRepository.save(collecteur) ;
            return  collecteur ;
        }else {
            throw  new EntityNotFoundException("candidat not found") ;
        }
    }

      //modifier un  collecteur
    public Collecteur  modifierCollecteur(Long id ,CollecteurDTO  collecteurDTO) {
        Optional<Collecteur> collecteurOptional = collecteurRepository.findById(id);
        if(collecteurOptional.isPresent()){
            Collecteur collecteur = collecteurOptional.get() ;
            collecteur.setDateCollecte(collecteurDTO.getDateCollecte());
            collecteur.setNumeroCarteElecteur(collecteurDTO.getNumeroCarteElecteur());
           return  collecteurRepository.save(collecteur) ;
        }else {
            throw  new RuntimeException("cette clolecteur n'existe pas ") ;
        }

    }

    // supprimer un collecteur
    public void deleteCollecteur(Long id){
        collecteurRepository.deleteById(id) ;
    }

    //rechecher une parrainage par numero
    public  Collecteur findCollecteur(Long id ) {
        Optional<Collecteur> collecteurOptional  = collecteurRepository.findById(id) ;

        return  collecteurOptional.orElse(null) ;
    }

    
}
