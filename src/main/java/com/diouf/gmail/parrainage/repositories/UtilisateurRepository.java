package com.diouf.gmail.parrainage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diouf.gmail.parrainage.entites.Utilisateur;

public interface UtilisateurRepository  extends JpaRepository<Utilisateur , Long> {
    public Utilisateur findByEmail(String email);
}
