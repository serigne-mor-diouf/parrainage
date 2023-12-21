package com.diouf.gmail.parrainage.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidat")
public class Candidat  extends Utilisateur implements Serializable{
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(name = "numero_candidat")

    private String numeroCandidat;
    @JsonIgnore
    @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL)
    private List<DelegueRegional> delegues;
    @JsonIgnore
    @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL)
    private List<Parrainage> parrainages;
    @JsonIgnore
    @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL)
    private List<Collecteur>collecteurs ;

    // Constructeurs
    public Candidat() {
        // Constructeur par défaut
    }

    public Candidat(String numeroCandidat) {
        this.numeroCandidat = numeroCandidat;
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

@Override
@JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return List.of(new SimpleGrantedAuthority("CANDIDAT"));
      //return List.of(new SimpleGrantedAuthority("PATIENT") , new SimpleGrantedAuthority("USER"));
    }
   

}

