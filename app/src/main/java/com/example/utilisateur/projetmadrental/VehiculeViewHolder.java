package com.example.utilisateur.projetmadrental;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class VehiculeViewHolder extends RecyclerView.ViewHolder {
    // TextView intitulé course :
    public TextView textViewLibellenom;
    // Constructeur :

    public VehiculeViewHolder(View itemView)
    {
        super(itemView);
        textViewLibellenom = itemView.findViewById(R.id.libelle_vehicule);
    }
}
