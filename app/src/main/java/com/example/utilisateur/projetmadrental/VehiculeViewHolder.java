package com.example.utilisateur.projetmadrental;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class VehiculeViewHolder extends RecyclerView.ViewHolder {

    // TextView intitulé course :
    public TextView textViewLibellenom;
    public TextView textViewLibelleprix;
    public TextView textViewLibelleCO2;
    public TextView textViewLibellePromotion;
    public ImageView textViewLibelleimage;
    public View contentitem;
    // Constructeur :

    public VehiculeViewHolder(View itemView)
    {
        super(itemView);
        textViewLibellenom = itemView.findViewById(R.id.libelle_vehicule);
        textViewLibelleprix = itemView.findViewById(R.id.prix_vehicule);
        textViewLibelleCO2 = itemView.findViewById(R.id.co2_vehicule);
        textViewLibellePromotion = itemView.findViewById(R.id.Promotion_vehicule);
        textViewLibelleimage = itemView.findViewById(R.id.image_vehicule);
        contentitem = itemView.findViewById(R.id.frameobjrech);
        }

}
