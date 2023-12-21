package com.diouf.gmail.parrainage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diouf.gmail.parrainage.entites.Token;
import com.diouf.gmail.parrainage.entites.Utilisateur;


public interface TokenRepository  extends JpaRepository<Token , String>{
    Token findByUtilisateur(Utilisateur utilisateur) ;
}
