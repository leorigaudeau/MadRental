package com.example.utilisateur.projetmadrental;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ListeViewHolder extends RecyclerView.ViewHolder
{
    // TextView intitulé course :
    public TextView textViewLibelleIntutile;
    public TextView textViewLibellePrix;
    public TextView textViewLibelleDebut;
    public TextView textViewLibelleFin;
    public TextView textViewimageURL;
    // Constructeur :
    public ListeViewHolder(View itemView)
    {
        super(itemView);
        textViewLibelleIntutile = itemView.findViewById(R.id.object_intitule);
        textViewLibellePrix = itemView.findViewById(R.id.object_prix);
        textViewLibelleDebut = itemView.findViewById(R.id.object_debut);
        textViewLibelleFin = itemView.findViewById(R.id.object_fin);
       // textViewimageURL = itemView.findViewById(R.id.object_image);

    }
}
