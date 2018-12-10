package com.example.utilisateur.projetmadrental;

class Optveh {
    private Integer id;
    private String nom;
    private  Integer prix;

    public Optveh(Integer id, String nom, Integer prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
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

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }
}
