package com.diouf.gmail.parrainage.dto;

import com.diouf.gmail.parrainage.entites.Candidat;

public class CandidatDTO  extends UtilisateurDTO{
    
     private Long id;

    private String numeroCandidat;

    public CandidatDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCandidat() {
        return numeroCandidat;
    }

    public void setNumeroCandidat(String numeroCandidat) {
        this.numeroCandidat = numeroCandidat;
    }

    public Candidat toCandidat(){
        Candidat candidat = new Candidat() ;
        if (this.getNumeroCandidat() != null) {
            candidat.setNumeroCandidat(this.getNumeroCandidat());
        }
        updateCommonAttributes(candidat);
        return candidat ;
    }

    @Override
    public String toString() {
        return "{ id=" + id + ", numeroCandidat=" + numeroCandidat + ""+ super.toString()+"}";
    }


}
