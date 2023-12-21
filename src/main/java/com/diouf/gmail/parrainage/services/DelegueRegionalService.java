package com.diouf.gmail.parrainage.services;

import java.util.List;
import java.util.Optional;

import com.diouf.gmail.parrainage.dto.DelegueDTO;
import com.diouf.gmail.parrainage.entites.Candidat;
import com.diouf.gmail.parrainage.repositories.CandidatRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diouf.gmail.parrainage.entites.DelegueRegional;
import com.diouf.gmail.parrainage.repositories.DelegueRegionalRepository;

@Service
public class DelegueRegionalService {
    @Autowired
    private DelegueRegionalRepository regionalRepository ;

    @Autowired
    private CandidatRepository candidatRepository ;

      public List<DelegueRegional> getDelegueRegional(){
        return regionalRepository.findAll();
    }


    public DelegueRegional addDelegueRegional(DelegueDTO delegueDTO){

        Optional<Candidat>pars = candidatRepository.findById(delegueDTO.getCandidat());
        if(pars.isPresent()){
            Candidat candidat  =  pars.get() ;
            DelegueRegional delegueRegional = delegueDTO.toDelegue() ;
            delegueRegional.setCandidat(candidat);
             regionalRepository.save(delegueRegional) ;
             return  delegueRegional ;
        }else {
            throw new EntityNotFoundException("DELEGUER NOT FOUND");
        }

    }

      //modifier un apprenant
    public DelegueRegional  modifierDelegue(Long id ,DelegueDTO delegueDTO) {
       Optional<DelegueRegional> optionalDelegueRegional = regionalRepository.findById(id);
       if (optionalDelegueRegional.isPresent()) {
           DelegueRegional delegueRegional = optionalDelegueRegional.get() ;
           delegueRegional.setDateSignature(delegueDTO.getDateSignature());
           delegueRegional.setRegionDeCollecte(delegueDTO.getRegionDeCollecte());
           delegueRegional.setNumeroCarteElecteur(delegueDTO.getNumeroCarteElecteur());
           delegueRegional.setNumeroCarteIdentite(delegueDTO.getNumeroCarteIdentite());
           delegueRegional.setRepresentationDiplomatique(delegueDTO.getRepresentationDiplomatique());
           return  regionalRepository.save(delegueRegional);
       }
       else {
           throw  new RuntimeException("le deleguer not found") ;
       }
    }

    // supprimer une parrainage
    public void deleteDelegue(Long id){
        regionalRepository.deleteById(id) ;
    }

    //rechecher une parrainage par numero
    public  DelegueRegional findParrainage(Long id ) {
        Optional<DelegueRegional> delegeOptional  = regionalRepository.findById(id) ;

        return  delegeOptional.orElse(null) ;
    }
}
