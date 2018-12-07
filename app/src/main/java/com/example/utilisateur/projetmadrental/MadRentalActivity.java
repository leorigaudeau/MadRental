package com.example.utilisateur.projetmadrental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MadRentalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_rental);
        Button ButtonResa = (Button) findViewById(R.id.BTNmesresa);

        //Appel du "BTNmesresa"
        ButtonResa.setOnClickListener(new View.OnClickListener()      //Creation du listener sur ce bouton
        {
            public void onClick(View actuelView)    //au clic sur le bouton
            {
                Intent intent = new Intent(MadRentalActivity.this, ReservationActivity.class);  //Lancer l'activité DisplayVue
                startActivity(intent);    //Afficher la vue7
            }

        });
        Button ButtonProfil = (Button) findViewById(R.id.BTNprofil);
        //Appel du "BTNmesresa"
        ButtonProfil.setOnClickListener(new View.OnClickListener()      //Creation du listener sur ce bouton
        {
            public void onClick(View actuelView)    //au clic sur le bouton
            {
                Intent intent = new Intent(MadRentalActivity.this, ProfilActivity.class);  //Lancer l'activité DisplayVue
                startActivity(intent);    //Afficher la vue7
            }

        });

        Button ButtonRech = (Button) findViewById(R.id.BTNrech);
        //Appel du "BTNrech"
        ButtonRech.setOnClickListener(new View.OnClickListener()      //Creation du listener sur ce bouton
        {
            public void onClick(View actuelView)    //au clic sur le bouton
            {
                Intent intent = new Intent(MadRentalActivity.this, RechercheVecActivity.class);  //Lancer l'activité DisplayVue
                startActivity(intent);    //Afficher la vue7
            }

        });



    }
}
