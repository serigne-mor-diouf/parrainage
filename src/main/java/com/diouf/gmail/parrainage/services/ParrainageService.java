package com.diouf.gmail.parrainage.services;

import java.util.List;
import java.util.Optional;

import com.diouf.gmail.parrainage.entites.Candidat;
import com.diouf.gmail.parrainage.repositories.CandidatRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diouf.gmail.parrainage.dto.ParrainageDTO;
import com.diouf.gmail.parrainage.entites.Parrainage;
import com.diouf.gmail.parrainage.repositories.ParrainageRepository;

import jakarta.transaction.Transactional;

@Service
public class ParrainageService {

    @Autowired
    private ParrainageRepository parrainageRepository ;

    @Autowired
    private CandidatRepository candidatRepository ;

   
    

    public List<Parrainage> getParrainage(){
        return parrainageRepository.findAll();
    }

    public Parrainage addParrainsParrainage(ParrainageDTO parrainsDto){


        Optional<Candidat>candidatOptional = candidatRepository.findById(parrainsDto.getCandidat()) ;
        if (candidatOptional.isPresent()) {
            Candidat candidat =  candidatOptional.get();
            Parrainage parrainage = parrainsDto.toParrain();
            parrainage.setCandidat(candidat);
            parrainageRepository.save(parrainage) ;
            return parrainage;

        }
        else {
            throw new EntityNotFoundException("candidat introuvale") ;
        }
    }

      //modifier un apprenant
    public Parrainage  modifierParrainage( Long id ,ParrainageDTO parrainageDTO) {
       Optional<Parrainage>existeOptional = parrainageRepository.findById(id);
       if(existeOptional.isPresent()){
       
       Parrainage parrainage = existeOptional.get() ; 
       parrainage.setNumeroCarteElecteur(parrainageDTO.getNumeroCarteElecteur());
       parrainage.setNumeroCarteIdentite(parrainageDTO.getNumeroCarteIdentite()) ;
       parrainage.setDateSignature(parrainageDTO.getDateSignature());
       parrainage.setCirconscription(parrainageDTO.getCirconscription()) ;
       return parrainageRepository.save(parrainage) ;
      }
      else{
        throw new RuntimeException("le parrain n'existe pas pour id"+id) ;
      }
    }
    // supprimer une parrainage
    public void deletePArrainage(Long id){
        parrainageRepository.deleteById(id) ;
    }

    //rechecher une parrainage par numero
    public  Parrainage findParrainage(Long id) {
        Optional<Parrainage> parrainageOptional  = parrainageRepository.findById(id) ;

        return  parrainageOptional.orElse(null) ;
    }
}
