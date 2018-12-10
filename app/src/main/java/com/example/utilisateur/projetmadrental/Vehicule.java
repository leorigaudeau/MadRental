package com.example.utilisateur.projetmadrental;

import java.util.ArrayList;
import java.util.Map;

class Vehicule {
    private Integer id;
    private String nom;
    private String image;
    private Integer disponible;
    private Integer prixjournalierbase;
    private Integer promotion;
    private Integer agemin;
    private String categorieco2;
    private ArrayList<Equipement> equipements;
    private ArrayList<Optveh> otpions;

    public Vehicule(Integer id, String nom, String image, Integer disponible, Integer prixjournalierbase, Integer promotion, Integer agemin, String categorieco2, ArrayList<Equipement> equipements, ArrayList<Optveh> otpions) {
        this.id = id;
        this.nom = nom;
        this.image = image;
        this.disponible = disponible;
        this.prixjournalierbase = prixjournalierbase;
        this.promotion = promotion;
        this.agemin = agemin;
        this.categorieco2 = categorieco2;
        this.equipements = equipements;
        this.otpions = otpions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getDisponible() {
        return disponible;
    }

    public void setDisponible(Integer disponible) {
        this.disponible = disponible;
    }

    public Integer getPrixjournalierbase() {
        return prixjournalierbase;
    }

    public void setPrixjournalierbase(Integer prixjournalierbase) {
        this.prixjournalierbase = prixjournalierbase;
    }

    public Integer getPromotion() {
        return promotion;
    }

    public void setPromotion(Integer promotion) {
        this.promotion = promotion;
    }

    public Integer getAgemin() {
        return agemin;
    }

    public void setAgemin(Integer agemin) {
        this.agemin = agemin;
    }

    public String getCategorieco2() {
        return categorieco2;
    }

    public void setCategorieco2(String categorieco2) {
        this.categorieco2 = categorieco2;
    }

    public ArrayList<Equipement> getEquipements() {
        return equipements;
    }

    public void setEquipements(ArrayList<Equipement> equipements) {
        this.equipements = equipements;
    }

    public ArrayList<Optveh> getOtpions() {
        return otpions;
    }

    public void setOtpions(ArrayList<Optveh> otpions) {
        this.otpions = otpions;
    }
}
