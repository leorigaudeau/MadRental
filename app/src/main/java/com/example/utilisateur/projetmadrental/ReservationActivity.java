package com.example.utilisateur.projetmadrental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReservationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // init :
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        RecyclerView recyclerView = findViewById(R.id.liste_resa);
        // à ajouter pour de meilleures performances :
        recyclerView.setHasFixedSize(true);
        // layout manager, décrivant comment les items sont disposés :
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // contenu d'exemple :
        List<ObjtReservation> listObjc = new ArrayList<>();
            listObjc.add(new ObjtReservation("Buggy",194,"19/12/2018","25/01/2019"));
            listObjc.add(new ObjtReservation("Buggy",194,"19/12/2018","25/01/2019"));
            listObjc.add(new ObjtReservation("Buggy",194,"19/12/2018","25/01/2019"));
            listObjc.add(new ObjtReservation("Buggy",194,"19/12/2018","25/01/2019"));
            listObjc.add(new ObjtReservation("Buggy",194,"19/12/2018","25/01/2019"));
        // adapter :
        ListeAdapter coursesAdapter = new ListeAdapter(listObjc);
        recyclerView.setAdapter(coursesAdapter);
    }
}
