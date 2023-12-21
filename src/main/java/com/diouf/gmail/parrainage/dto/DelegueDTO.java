package com.diouf.gmail.parrainage.dto;

import java.util.Date;

import com.diouf.gmail.parrainage.entites.Candidat;
import com.diouf.gmail.parrainage.entites.DelegueRegional;

public class DelegueDTO  extends UtilisateurDTO{
    
     private Long id;

    private String numeroCarteElecteur;

    private String numeroCarteIdentite;

    private String regionDeCollecte;

    private String representationDiplomatique;

    private Date dateSignature;

    private Long candidat ;

    public DelegueDTO() {
     
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

    public void setDateSignature(Date dateSignature) {
        this.dateSignature = dateSignature;
    }

    public Long getCandidat() {
        return candidat;
    }

    public void setCandidat(Long candidat) {
        this.candidat = candidat;
    }

    public DelegueRegional toDelegue(){
        DelegueRegional delegueRegional = new DelegueRegional();
        if (this.getDateSignature() != null
        || this.getRepresentationDiplomatique()!= null
                || this.getRegionDeCollecte()!= null
                || this.getNumeroCarteElecteur() != null
                || this.getNumeroCarteIdentite() !=null
        ) {
            delegueRegional.setDateSignature(this.getDateSignature());
            delegueRegional.setRegionDeCollecte(this.getRegionDeCollecte());
            delegueRegional.setRepresentationDiplomatique(this.getRepresentationDiplomatique());
            delegueRegional.setNumeroCarteElecteur(this.getNumeroCarteElecteur());
            delegueRegional.setNumeroCarteIdentite(this.getNumeroCarteIdentite());
        }

        updateCommonAttributes(delegueRegional);
        return delegueRegional ;
    }

    @Override
    public String toString() {
        return "{ id=" + id + ", numeroCarteElecteur=" + numeroCarteElecteur + ", numeroCarteIdentite="
                + numeroCarteIdentite + ", regionDeCollecte=" + regionDeCollecte + ", representationDiplomatique="
                + representationDiplomatique + ", dateSignature=" + dateSignature + ", candidat=" + candidat + ""+ super.toString()+"}";
    }



}
