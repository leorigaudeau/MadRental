package com.example.utilisateur.projetmadrental;

import java.util.Date;

public class ObjtReservation {

    // Attributs :
    public String intitule;
    public Integer prix;
    public String debut;
    public String fin;

    public ObjtReservation(String intitule, Integer prix, String debut, String fin) {
        this.intitule = intitule;
        this.prix = prix;
        this.debut = debut;
        this.fin = fin;
    }
}
