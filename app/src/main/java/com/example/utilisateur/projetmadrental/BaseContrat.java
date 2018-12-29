package com.example.utilisateur.projetmadrental;

import android.provider.BaseColumns;

public final class BaseContrat
{
    // constructeur privé afin de ne pas instancier la classe :
    private BaseContrat() {}

    // contenu de la table "courses" :
    public static class CoursesContrat implements BaseColumns
    {
        public static final String TABLE_COURSES = "vehicule";
        public static final String COLONNE_NOM = "nom";
        public static final String COLONNE_PRIX = "prix";
        public static final String COLONNE_DATEDEBUT= "dateDebut";
        public static final String COLONNE_DATEFIN = "dateFin";

    }
}