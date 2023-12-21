package com.diouf.gmail.parrainage.entites;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.Email;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Utilisation de l'héritage "table par classe" (table per class)
public class Utilisateur implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    
    private String nom;

    private String prenom;
    
    private String contact ;

    @Column(nullable = false)
    private String password ;

    @Email
    @Column(nullable = false , unique = true)
    private String email ;

    private String adresse ;

    private String sexe ;

    private int age ;

    private boolean accountNonExpired ;
    private boolean accountNonLocked ;
    private boolean credentialsNonExpired ;
    private boolean enabled ;

    public Utilisateur(){
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
    }

    public Utilisateur(String nom, String prenom, String contact, String password, String email, String adresse,
            String sexe, int age) {
        this() ; //appel du premier constructeur
        this.nom = nom;
        this.prenom = prenom;
        this.contact = contact;
        this.password = password;
        this.email = email;
        this.adresse = adresse;
        this.sexe = sexe;
        this.age = age;
    }
  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Utilisateur other = (Utilisateur) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>() ;
    }

    @Override
    public String getPassword() {
        return this.password ;
    }

    @Override
    public String getUsername() {
        return this.email ;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired ;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked ;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired ;
    }

    @Override
    public boolean isEnabled() {
        return  this.enabled ;
    }
    
    public boolean isValid(){
        return accountNonExpired 
                && accountNonLocked 
                && credentialsNonExpired 
                && enabled ;
    }

    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", contact=" + contact + ", password="
                + password + ", email=" + email + ", adresse=" + adresse + ", sexe=" + sexe + ", age=" + age
                + ", accountNonExpired=" + accountNonExpired + ", accountNonLocked=" + accountNonLocked
                + ", credentialsNonExpired=" + credentialsNonExpired + ", enabled=" + enabled + "]";
    }

}
