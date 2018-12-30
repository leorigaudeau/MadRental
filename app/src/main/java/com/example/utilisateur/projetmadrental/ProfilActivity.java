package com.example.utilisateur.projetmadrental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfilActivity extends AppCompatActivity {
    String Snom ;
    String Sprenom;
    String Sage;
    EditText IDnom;
    EditText IDprenom ;
    EditText IDnaissance;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState!= null){
            Snom = savedInstanceState.getString("nom");
            Sprenom = savedInstanceState.getString("prenom");
            Sage = savedInstanceState.getString("age");
        }

        setContentView(R.layout.activity_profil);

        Button btn = findViewById(R.id.BTNvalider);
        IDnom = findViewById(R.id.INPNom);
        IDprenom = findViewById(R.id.INPPrenom);
        IDnaissance = findViewById(R.id.INPNaissance);

        btn.setOnClickListener(new View.OnClickListener()      //Creation du listener sur ce bouton
        {
            public void onClick(View actuelView)    //au clic sur le bouton
            {
                Snom= String.valueOf(IDnom.getText());
                Sprenom= String.valueOf(IDprenom.getText());
                Sage= String.valueOf(IDnaissance.getText());
            }

        });
    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        Log.i("onsavedinst",savedInstanceState.getString("nom"));
        IDnom.setHint(savedInstanceState.getString("nom"));
        IDprenom.setHint(savedInstanceState.getString("prenom"));
        IDnaissance.setHint(savedInstanceState.getString("age"));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        // etc.
        savedInstanceState.putString("nom", Snom);
        savedInstanceState.putString("prenom", Sprenom);
        savedInstanceState.putString("age",Sage);

    }


}
