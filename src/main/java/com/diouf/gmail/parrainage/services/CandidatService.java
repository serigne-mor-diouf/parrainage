package com.diouf.gmail.parrainage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diouf.gmail.parrainage.dto.CandidatDTO;
import com.diouf.gmail.parrainage.entites.Candidat;
import com.diouf.gmail.parrainage.repositories.CandidatRepository;

@Service
public class CandidatService {
    @Autowired
    private CandidatRepository candidatRepository   ;  

    // lister les Candiadatnt
    public List<Candidat>getCandidat(){
        return candidatRepository.findAll() ;
    }


    public Candidat addCandidat(CandidatDTO candidatDTO){
        Candidat candidat = candidatDTO.toCandidat();
        candidatRepository.save(candidat);
        return candidat ;
    }

    //modifier un candidat
    public Candidat  editerCandidat(Long id , CandidatDTO  candidatDTO) {
        Optional<Candidat> candidatOptional = candidatRepository.findById(id) ;
        if (candidatOptional.isPresent()){
            Candidat candidat = candidatOptional.get() ;
            candidat.setNumeroCandidat(candidatDTO.getNumeroCandidat());
            return  candidatRepository.save(candidat) ;
        }else {
            throw new RuntimeException("candidat not found") ;
        }
    }

    //rechercheer un candidat dont on connait son identifiant
    public  Candidat findCandidat(Long id) {
        Optional<Candidat> candidatOptional  = candidatRepository.findById(id);

        return  candidatOptional.orElse(null) ;
    }


    public void deleteCandiadt(Long id){
        candidatRepository.deleteById(id);
    }

}
