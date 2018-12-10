package com.example.utilisateur.projetmadrental;

import java.util.Date;

public class ObjtReservation {

    // Attributs :
    public String intitule;
    public Integer prix;
    public String debut;
    public String fin;
    public String imageURL;

    public ObjtReservation(String intitule, Integer prix, String debut, String fin,String image) {
        this.intitule = intitule;
        this.prix = prix;
        this.debut = debut;
        this.fin = fin;
        this.imageURL=image;
    }
}
