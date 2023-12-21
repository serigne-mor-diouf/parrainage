package com.diouf.gmail.parrainage.entites ;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Token {
   @Id
   private String valeur ; 

   private Boolean revoquer ;

   @Column(nullable = false)
   private Date dateCreation ;

   @Column(nullable = false)
   private Date validite ;

   private Date deconnection  ; 

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur ;


    public Token(String valeur, Date dateCreation, Date validite, Utilisateur utilisateur) {
        this();
        this.valeur = valeur;
        this.dateCreation = dateCreation;
        this.validite = validite;
        this.utilisateur = utilisateur;
    }
    
    public Token() {
        this.revoquer = false ;
    }

    
    public boolean isTokenValide(){
        Date maintenant = new Date();
        return !revoquer && maintenant.before(validite) && (deconnection == null);
    }


    
    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Boolean getRevoquer() {
        return revoquer;
    }

    public void setRevoquer(Boolean revoquer) {
        this.revoquer = revoquer;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getValidite() {
        return validite;
    }

    public void setValidite(Date validite) {
        this.validite = validite;
    }

    public Date getDeconnection() {
        return deconnection;
    }

    public void setDeconnection(Date deconnection) {
        this.deconnection = deconnection;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Utilisateur getUtilisateur() {       
        return utilisateur;
    }

}
