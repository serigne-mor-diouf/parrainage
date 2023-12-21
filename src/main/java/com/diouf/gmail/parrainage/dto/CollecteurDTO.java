package com.diouf.gmail.parrainage.dto;

import java.util.Date;

import com.diouf.gmail.parrainage.entites.Candidat;
import com.diouf.gmail.parrainage.entites.Collecteur;

public class CollecteurDTO extends UtilisateurDTO {
    private Long id;

    private String numeroCarteElecteur;

    private Date dateCollecte;
    
    private Long candidat ;


    public CollecteurDTO() {
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

    public Long getCandidat() {
        return candidat;
    }

    public void setCandidat(Long candidat) {
        this.candidat = candidat;
    }

    public Collecteur toCollecteur(){
        Collecteur collecteur = new Collecteur();
        if(this.getNumeroCarteElecteur()!= null 
        || this.getDateCollecte() != null
        ){
            collecteur.setDateCollecte(this.getDateCollecte());
            collecteur.setNumeroCarteElecteur(this.getNumeroCarteElecteur());
        }
    updateCommonAttributes(collecteur);
    return collecteur ;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", numeroCarteElecteur=" + numeroCarteElecteur + ", dateCollecte="
                + dateCollecte + ", candidat=" + candidat +""+super.toString()+ "}";
    }


}
