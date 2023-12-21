package com.diouf.gmail.parrainage.dto;

import com.diouf.gmail.parrainage.entites.Candidat;
import com.diouf.gmail.parrainage.entites.Parrainage;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class ParrainageDTO  extends UtilisateurDTO{
    
    private Long id;
    
    private Date dateSignature;
    private String numeroCarteElecteur;
    
    private String numeroCarteIdentite;

    private String circonscription;

    private Long candidat ;

    public ParrainageDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(Date dateSignature) {
        this.dateSignature = dateSignature;
    }

    public Long getCandidat() {
        return candidat;
    }

    public void setCandidat(Long candidat) {
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

    public Parrainage toParrain() {
        Parrainage parrainage = new Parrainage();
        // Logs de débogage
        System.out.println("DateSignature: " + this.getDateSignature());
        System.out.println("Candidat: " + this.getCandidat());
        // ... ajoutez des logs pour d'autres attributs
        // Mise à jour des attributs spécifiques de Parrainage
       // Mise à jour des attributs spécifiques de Parrainage
            if (this.getDateSignature() != null
                    || this.getCirconscription() != null
                    || this.getNumeroCarteElecteur() != null
                    || this.getNumeroCarteIdentite() != null) {
            parrainage.setDateSignature(this.getDateSignature());
            parrainage.setCirconscription(this.getCirconscription());
            parrainage.setNumeroCarteElecteur(this.getNumeroCarteElecteur());
            parrainage.setNumeroCarteIdentite(this.getNumeroCarteIdentite());
            }

        System.out.println("Parrainage après mise à jour des attributs spécifiques: " + parrainage);
    
        // Mise à jour des attributs communs
        updateCommonAttributes(parrainage);
        
        // Logs de débogage
        System.out.println("Parrainage final: " + parrainage);
    
        return parrainage;
    }
    

    @Override
    public String toString() {
        return " {id=" + id + ", dateSignature=" + dateSignature + ", numeroCarteElecteur="
                + numeroCarteElecteur + ", numeroCarteIdentite=" + numeroCarteIdentite + ", circonscription="
                + circonscription + ", candidat=" + candidat +"" +super.toString()+"}";
    }
}
