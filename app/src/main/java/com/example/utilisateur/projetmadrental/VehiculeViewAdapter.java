package com.example.utilisateur.projetmadrental;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        holder.textViewLibellenom.setText(listeCourses.get(position).getNom());
    }
    @Override
    public int getItemCount()
    {
        return listeCourses.size();
    }
}