package com.diouf.gmail.parrainage.services;



import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diouf.gmail.parrainage.entites.Utilisateur;
import com.diouf.gmail.parrainage.repositories.UtilisateurRepository;


@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
  
    //liter les utilisateurs
    public List<Utilisateur>  getUtilisateurs(){
       return utilisateurRepository.findAll() ;
    }

        public Utilisateur findByEmail(String email){
            return utilisateurRepository.findByEmail(email) ;
    }

}


