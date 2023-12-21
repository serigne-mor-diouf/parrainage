package com.diouf.gmail.parrainage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diouf.gmail.parrainage.entites.Parrainage;

public interface ParrainageRepository extends JpaRepository<Parrainage , Long> {
    
}
