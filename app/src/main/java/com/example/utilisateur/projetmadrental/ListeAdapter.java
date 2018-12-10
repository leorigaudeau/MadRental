package com.example.utilisateur.projetmadrental;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class ListeAdapter extends RecyclerView.Adapter<ListeViewHolder>
{
    // Liste d'objets métier :
    private List<ObjtReservation> listObjc;
    // Constructeur :
    public ListeAdapter(List<ObjtReservation> listObjc)
    {
        this.listObjc = listObjc;
    }
    @Override
    public ListeViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View viewObjc = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listeobjcresa, parent, false);
        return new ListeViewHolder(viewObjc);
    }
    @Override
    public void onBindViewHolder(ListeViewHolder holder, int position)
    {

        //holder.textViewimageURL.
        //Picasso.with(ReservationActivity.this)
          //      .load("s519716619.onlinehome.fr/exchange/madrental/images/"+listObjc.get(position).imageURL)
            //    .fit()
              //  .centerCrop() // ou centerInside()
                //.into((Target) holder.textViewimageURL);
        holder.textViewLibelleIntutile.setText(listObjc.get(position).intitule);
        holder.textViewLibellePrix.setText(" - "+String.valueOf(listObjc.get(position).prix)+" € ");
        holder.textViewLibelleDebut.setText("Date de début :"+listObjc.get(position).debut);
        holder.textViewLibelleFin.setText("Date de fin :"+listObjc.get(position).fin);
    }
    @Override
    public int getItemCount()
    {
        return listObjc.size();
    }

}