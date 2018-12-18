package com.example.utilisateur.projetmadrental;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

public class VehiculeViewAdapter extends RecyclerView.Adapter<VehiculeViewHolder>
{
    /// Liste d'objets métier :
    private List<Vehicule> listeCourses;
    // Constructeur :
    public VehiculeViewAdapter(List<Vehicule> listeCourses)
    {
        this.listeCourses = listeCourses;
    }
    @Override
    public VehiculeViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View viewCourse = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listeobjrech, parent, false);
        return new VehiculeViewHolder(viewCourse);
    }

    @Override
    public void onBindViewHolder(VehiculeViewHolder holder, int position)
    {
        Picasso.with(holder.textViewLibelleimage.getContext())
                .load("http://s519716619.onlinehome.fr/exchange/madrental/images/"+listeCourses.get(position).getImage())
                .fit()
                .centerCrop()
                .into(holder.textViewLibelleimage);
        holder.textViewLibellenom.setText(listeCourses.get(position).getNom());
        holder.textViewLibelleCO2.setText("Catégorie CO2 : "+listeCourses.get(position).getCategorieco2());
        holder.textViewLibelleprix.setText(String.valueOf(listeCourses.get(position).getPrixjournalierbase()+"€ / jour"));
        if (listeCourses.get(position).getPromotion()!=0){
            holder.textViewLibellePromotion.setBackgroundColor(Color.RED);
            holder.textViewLibellePromotion.setText("-"+listeCourses.get(position).getPromotion()+"%");
        }
    }
    @Override
    public int getItemCount()
    {
        return listeCourses.size();
    }
}