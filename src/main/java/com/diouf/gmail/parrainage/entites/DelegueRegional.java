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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "delegueregional")
public class DelegueRegional  extends  Utilisateur implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 15)
    private String numeroCarteElecteur;

    @Column(unique = true, nullable = false, length = 17)
    private String numeroCarteIdentite;

    private String regionDeCollecte;

    private String representationDiplomatique;

    @Temporal(TemporalType.DATE)
    private Date dateSignature;

    @ManyToOne
    @JoinColumn(name = "candidat_id")
    private Candidat candidat ;

    public DelegueRegional() {
    }

    public DelegueRegional(String nom, String prenom, String contact, String password, String email, String adresse,
            String sexe, int age) {
        super(nom, prenom, contact, password, email, adresse, sexe, age);
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

    public String getRegionDeCollecte() {
        return regionDeCollecte;
    }

    public void setRegionDeCollecte(String regionDeCollecte) {
        this.regionDeCollecte = regionDeCollecte;
    }

    public String getRepresentationDiplomatique() {
        return representationDiplomatique;
    }

    public void setRepresentationDiplomatique(String representationDiplomatique) {
        this.representationDiplomatique = representationDiplomatique;
    }

    public Date getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(Date dateSignatureElecteur) {
        this.dateSignature = dateSignatureElecteur;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return List.of(new SimpleGrantedAuthority("DELEGUE"));
      //return List.of(new SimpleGrantedAuthority("PATIENT") , new SimpleGrantedAuthority("USER"));
    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }
}

