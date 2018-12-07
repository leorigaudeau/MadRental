package com.example.utilisateur.projetmadrental;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MadRentalActivity extends AppCompatActivity {

    TextView Title;

    Typeface ultrafresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_rental);


        Title = (TextView)findViewById(R.id.title);

        ultrafresh = Typeface.createFromAsset(getAssets(), "ultrafresh.ttf");

        Title.setTypeface(ultrafresh);
    }
}
