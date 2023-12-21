package com.diouf.gmail.parrainage.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "collecteur")
public class Collecteur extends  Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(unique = true, nullable = false, length = 15)
    private String numeroCarteElecteur;

    private Date dateCollecte;

    @ManyToOne
    @JoinColumn(name = "candidat_id", nullable = true)
    private Candidat candidat ;

    

    public Collecteur() {
      
    }


   


    public Collecteur(String numeroCarteElecteur, Date dateCollecte, Candidat candidat) {
        this.numeroCarteElecteur = numeroCarteElecteur;
        this.dateCollecte = dateCollecte;
        this.candidat = candidat;
    }





    public Collecteur(String nom, String prenom, String contact, String password, String email, String adresse,
            String sexe, int age, String numeroCarteElecteur, Date dateCollecte, Candidat candidat) {
        super(nom, prenom, contact, password, email, adresse, sexe, age);
        this.numeroCarteElecteur = numeroCarteElecteur;
        this.dateCollecte = dateCollecte;
        this.candidat = candidat;
    }





    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }


    public String getNumeroCarteElecteur() {
        return numeroCarteElecteur;
    }

    public void setNumeroCarteElecteur(String numeroCarteElecteur) {
        this.numeroCarteElecteur = numeroCarteElecteur;
    }

    public Date getDateCollecte() {
        return dateCollecte;
    }

    public void setDateCollecte(Date dateCollecte) {
        this.dateCollecte = dateCollecte;
    }

    @JsonIgnore
   @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return List.of(new SimpleGrantedAuthority("COLLECTEURS"));
      //return List.of(new SimpleGrantedAuthority("PATIENT") , new SimpleGrantedAuthority("USER"));
    }


public Candidat getCandidat() {
    return candidat;
}


public void setCandidat(Candidat candidat) {
    this.candidat = candidat;
}

   
}

