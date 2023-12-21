package com.diouf.gmail.parrainage.entites;


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="parrainage")
public class Parrainage extends Utilisateur  implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String numeroCarteElecteur;
    
    private String numeroCarteIdentite;

    private String circonscription;
    
    //la date de signature de l'électeur.
 
    private Date dateSignature;

    @ManyToOne
    @JoinColumn(name = "candidat_id")
    private Candidat candidat ;

    public Parrainage(){

    }

    public Parrainage(String nom, String prenom, String contact, String password, String email, String adresse,
            String sexe, int age, String numeroCarteElecteur, String numeroCarteIdentite, String circonscription,
            Date dateSignature, Candidat candidat) {
        super(nom, prenom, contact, password, email, adresse, sexe, age);
        this.numeroCarteElecteur = numeroCarteElecteur;
        this.numeroCarteIdentite = numeroCarteIdentite;
        this.circonscription = circonscription;
        this.dateSignature = dateSignature;
        this.candidat = candidat;
    }




    public String getNumeroCarteElecteur() {
        return numeroCarteElecteur;
    }

    public void setNumeroCarteElecteur(String numeroCarteElecteur) {
        this.numeroCarteElecteur = numeroCarteElecteur;
    }

   public String getNumeroCarteIdentite() {
       return numeroCarteIdentite;
   }

   public void setNumeroCarteIdentite(String numeroCarteIdentite) {
       this.numeroCarteIdentite = numeroCarteIdentite;
   }

    public String getCirconscription() {
        return circonscription;
    }

    public void setCirconscription(String circonscription) {
        this.circonscription = circonscription;
    }

    public Date getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(Date dateSignatureElecteur) {
        this.dateSignature = dateSignatureElecteur;
    }
    

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return List.of(new SimpleGrantedAuthority("PARRAINS"));
      //return List.of(new SimpleGrantedAuthority("PATIENT") , new SimpleGrantedAuthority("USER"));
    }







    public Long getId() {
        return id;
    }







    public void setId(Long id) {
        this.id = id;
    }
   
}

