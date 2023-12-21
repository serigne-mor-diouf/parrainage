package com.diouf.gmail.parrainage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diouf.gmail.parrainage.entites.Candidat;

public interface CandidatRepository  extends JpaRepository<Candidat  , Long>{
     
}
