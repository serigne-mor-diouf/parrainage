package com.diouf.gmail.parrainage.dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.diouf.gmail.parrainage.entites.Utilisateur;


public class UtilisateurDTO {
    
     private Long id ;
    
    private String nom;

    private String prenom;
    
    private String contact ;

    private String password ;

    private String email ;

    private String adresse ;

    private String sexe ;

    private int age ;

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

    public String getPassword() {
        return password;
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

    public void updateCommonAttributes(Utilisateur utilisateur) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(this.getPassword());
    
        utilisateur.setNom(this.getNom());
        utilisateur.setPrenom(this.getPrenom());
        utilisateur.setSexe(this.getSexe());
        utilisateur.setAge(this.getAge());
        utilisateur.setAdresse(this.getAdresse());
        utilisateur.setContact(this.getContact());
        utilisateur.setEmail(this.getEmail());
        utilisateur.setPassword(hashedPassword);
    }

    @Override
    public String toString() {
        return "UtilisateurDTO [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", contact=" + contact
                + ", password=" + password + ", email=" + email + ", adresse=" + adresse + ", sexe=" + sexe + ", age="
                + age + "]";
    }   
}
