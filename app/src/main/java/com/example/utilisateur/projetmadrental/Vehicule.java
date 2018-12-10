package com.example.utilisateur.projetmadrental;

import java.util.ArrayList;
import java.util.Map;

class Vehicule {
    private Integer id;
    private String nom;
    private String image;
    private boolean disponible;
    private Integer prixjournalierbase;
    private Integer promotion;
    private Integer agemin;
    private String categorieco2;
    private ArrayList<Equipement> equipement;
    private ArrayList<Optveh> otpion;

    public Vehicule(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
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

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
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

    public ArrayList<Equipement> getEquipement() {
        return equipement;
    }

    public void setEquipement(ArrayList<Equipement> equipement) {
        this.equipement = equipement;
    }

    public ArrayList<Optveh> getOtpion() {
        return otpion;
    }

    public void setOtpion(ArrayList<Optveh> otpion) {
        this.otpion = otpion;
    }
}
