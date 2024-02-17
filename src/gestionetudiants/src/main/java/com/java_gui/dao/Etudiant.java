package com.java_gui.dao;

public class Etudiant {
    private int id;
    private String nom, prenom, sexe, filiere;

    public Etudiant() {
    }

    public Etudiant(String nom, String prenom, String filiere, String sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.filiere = filiere;
        this.sexe = sexe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

}
