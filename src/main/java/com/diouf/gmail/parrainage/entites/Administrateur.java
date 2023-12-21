package com.diouf.gmail.parrainage.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="administrateur")
public class Administrateur extends Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id  ;

    public Administrateur() {
    }

    public Administrateur(String nom, String prenom, String contact, String password, String email, String adresse,
            String sexe, int age) {
        super(nom, prenom, contact, password, email, adresse, sexe, age);
    }

      @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
   
    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return List.of(new SimpleGrantedAuthority("ADMIN"));
        //return List.of(new SimpleGrantedAuthority("MEDECIN") , new SimpleGrantedAuthority("USER"));
    }

    
}
