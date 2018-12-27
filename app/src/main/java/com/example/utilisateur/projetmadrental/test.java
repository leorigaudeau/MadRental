package com.example.utilisateur.projetmadrental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        TextView txt = findViewById(R.id.txt);

        int idItem = getIntent().getIntExtra("id",0);
        txt.setText(idItem);

    }
}
