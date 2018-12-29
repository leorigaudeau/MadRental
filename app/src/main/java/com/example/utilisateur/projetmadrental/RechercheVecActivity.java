package com.example.utilisateur.projetmadrental;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Build;
import android.preference.PreferenceActivity;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class RechercheVecActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_vec);
        // client HTTP :
        AsyncHttpClient client = new AsyncHttpClient();
        // paramètres :
        RequestParams requestParams = new RequestParams();
        requestParams.put("parametre", "1234");
        // Appel :
        client.post("http://s519716619.onlinehome.fr/exchange/madrental/get-vehicules.php", requestParams, new AsyncHttpResponseHandler() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                Log.i("RenduJson", "in success");
                String retour = new String(response);
                Gson gson = new Gson();
                List<Vehicule> listeVehicules = new ArrayList<>();
                ArrayList<Equipement> listeEquipement = new ArrayList<>();
                ArrayList<Optveh> listeOptveh = new ArrayList<>();
                try {
                    JSONArray jsonArray = new JSONArray(retour);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        final JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Integer vID = Integer.parseInt(jsonObject.getString("id"));
                        String vName = jsonObject.getString("nom");
                        String vImage = jsonObject.getString("image");
                        Integer vAvailable = Integer.parseInt(jsonObject.getString("disponible"));
                        Integer vBaseDailyPrice = Integer.parseInt(jsonObject.getString("prixjournalierbase"));
                        Integer vSale = Integer.parseInt(jsonObject.getString("promotion"));
                        Integer vAgeMin = Integer.parseInt(jsonObject.getString("agemin"));
                        String vCO2Category = jsonObject.getString("categorieco2");
                        JSONArray vEquipments = jsonObject.getJSONArray("equipements");
                        JSONArray vOptions = jsonObject.getJSONArray("options");


                        for (int e = 0; e < vEquipments.length(); e++) {
                            JSONObject jsonObjectEquiment = vEquipments.getJSONObject(e);
                            Integer eid = Integer.parseInt(jsonObjectEquiment.getString("id"));
                            String eName = jsonObjectEquiment.getString("nom");
                            listeEquipement.add(new Equipement(eid, eName));
                        }

                        for (int o = 0; o < vOptions.length(); o++) {
                            JSONObject jsonObjectOption = vOptions.getJSONObject(o);
                            Integer oid = Integer.parseInt(jsonObject.getString("id"));
                            String oName = jsonObjectOption.getString("nom");
                            Integer oprix = Integer.parseInt(jsonObjectOption.getString("prix"));
                            listeOptveh.add(new Optveh(oid, oName, oprix));


                        }
                        Vehicule vehicule = new Vehicule(vID, vName, vImage, vAvailable, vBaseDailyPrice, vSale, vAgeMin, vCO2Category, listeEquipement, listeOptveh);
                        listeVehicules.add(vehicule);




                        RecyclerView recyclerView = findViewById(R.id.liste_rechVec);
                        // à ajouter pour de meilleures performances :
                        recyclerView.setHasFixedSize(true);
                        // layout manager, décrivant comment les items sont disposés :
                        LinearLayoutManager layoutManager = new LinearLayoutManager(RechercheVecActivity.this);
                        recyclerView.setLayoutManager(layoutManager);
                        VehiculeViewAdapter coursesAdapter = new VehiculeViewAdapter(listeVehicules);
                        recyclerView.setAdapter(coursesAdapter);

                    }
                } catch (Exception e) {
                    Log.i("RenduJson", "error" + String.valueOf(listeVehicules));

                    e.printStackTrace();
                }
                Log.i("RenduJson", "final" + String.valueOf(listeVehicules));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers,
                                  byte[] errorResponse, Throwable e) {
                Log.e("infoJson", e.toString());
            }
        });
        LinearLayout parent = (LinearLayout)findViewById(R.id.parent);
        parent.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);


        View text = findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View message = findViewById(R.id.message);
                ViewGroup.LayoutParams params = message.getLayoutParams();

                params.height = params.height == 0 ? ViewGroup.LayoutParams.WRAP_CONTENT : 0;

                message.setLayoutParams(params);

            }
        });


        final Switch s = findViewById(R.id.switchfilt);
        final Switch sa = findViewById(R.id.switchfiltAge);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // client HTTP :
                AsyncHttpClient client = new AsyncHttpClient();
                // paramètres :
                RequestParams requestParams = new RequestParams();
                if (s.isChecked()) {
                    requestParams.put("promotion", "1");
                }
                if (sa.isChecked());{
                    requestParams.put("agemin","21");
                }
                    // Appel :
                    client.get("http://s519716619.onlinehome.fr/exchange/madrental/get-vehicules.php", requestParams, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                            Log.i("RenduJson", "in success");
                            String retour = new String(response);
                            Gson gson = new Gson();
                            List<Vehicule> listeVehicules = new ArrayList<>();
                            ArrayList<Equipement> listeEquipement = new ArrayList<>();
                            ArrayList<Optveh> listeOptveh = new ArrayList<>();
                            try {
                                JSONArray jsonArray = new JSONArray(retour);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    Integer vID = Integer.parseInt(jsonObject.getString("id"));
                                    String vName = jsonObject.getString("nom");
                                    String vImage = jsonObject.getString("image");
                                    Integer vAvailable = Integer.parseInt(jsonObject.getString("disponible"));
                                    Integer vBaseDailyPrice = Integer.parseInt(jsonObject.getString("prixjournalierbase"));
                                    Integer vSale = Integer.parseInt(jsonObject.getString("promotion"));
                                    Integer vAgeMin = Integer.parseInt(jsonObject.getString("agemin"));
                                    String vCO2Category = jsonObject.getString("categorieco2");
                                    JSONArray vEquipments = jsonObject.getJSONArray("equipements");
                                    JSONArray vOptions = jsonObject.getJSONArray("options");


                                    for (int e = 0; e < vEquipments.length(); e++) {
                                        JSONObject jsonObjectEquiment = vEquipments.getJSONObject(e);
                                        Integer eid = Integer.parseInt(jsonObjectEquiment.getString("id"));
                                        String eName = jsonObjectEquiment.getString("nom");
                                        listeEquipement.add(new Equipement(eid, eName));
                                    }

                                    for (int o = 0; o < vOptions.length(); o++) {
                                        JSONObject jsonObjectOption = vOptions.getJSONObject(o);
                                        Integer oid = Integer.parseInt(jsonObject.getString("id"));
                                        String oName = jsonObjectOption.getString("nom");
                                        Integer oprix = Integer.parseInt(jsonObjectOption.getString("prix"));
                                        listeOptveh.add(new Optveh(oid, oName, oprix));


                                    }
                                    Vehicule vehicule = new Vehicule(vID, vName, vImage, vAvailable, vBaseDailyPrice, vSale, vAgeMin, vCO2Category, listeEquipement, listeOptveh);
                                    listeVehicules.add(vehicule);

                                    RecyclerView recyclerView = findViewById(R.id.liste_rechVec);
                                    // à ajouter pour de meilleures performances :
                                    recyclerView.setHasFixedSize(true);
                                    // layout manager, décrivant comment les items sont disposés :
                                    LinearLayoutManager layoutManager = new LinearLayoutManager(RechercheVecActivity.this);
                                    recyclerView.setLayoutManager(layoutManager);
                                    VehiculeViewAdapter coursesAdapter = new VehiculeViewAdapter(listeVehicules);
                                    recyclerView.setAdapter(coursesAdapter);

                                }
                            } catch (Exception e) {
                                Log.i("RenduJson", "error" + String.valueOf(listeVehicules));

                                e.printStackTrace();
                            }
                            Log.i("RenduJson", "final" + String.valueOf(listeVehicules));
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers,
                                              byte[] errorResponse, Throwable e) {
                            Log.e("infoJson", e.toString());
                        }
                    });
                LinearLayout parent = (LinearLayout)findViewById(R.id.parent);
                parent.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
            }
        });
        sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // client HTTP :
                AsyncHttpClient client = new AsyncHttpClient();
                // paramètres :
                RequestParams requestParams = new RequestParams();
                if (s.isChecked()) {
                    requestParams.put("promotion", "1");
                }
                if (sa.isChecked());{
                    requestParams.put("agemin","21");
                }
                // Appel :
                client.get("http://s519716619.onlinehome.fr/exchange/madrental/get-vehicules.php", requestParams, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                        Log.i("RenduJson", "in success");
                        String retour = new String(response);
                        Gson gson = new Gson();
                        List<Vehicule> listeVehicules = new ArrayList<>();
                        ArrayList<Equipement> listeEquipement = new ArrayList<>();
                        ArrayList<Optveh> listeOptveh = new ArrayList<>();
                        try {
                            JSONArray jsonArray = new JSONArray(retour);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Integer vID = Integer.parseInt(jsonObject.getString("id"));
                                String vName = jsonObject.getString("nom");
                                String vImage = jsonObject.getString("image");
                                Integer vAvailable = Integer.parseInt(jsonObject.getString("disponible"));
                                Integer vBaseDailyPrice = Integer.parseInt(jsonObject.getString("prixjournalierbase"));
                                Integer vSale = Integer.parseInt(jsonObject.getString("promotion"));
                                Integer vAgeMin = Integer.parseInt(jsonObject.getString("agemin"));
                                String vCO2Category = jsonObject.getString("categorieco2");
                                JSONArray vEquipments = jsonObject.getJSONArray("equipements");
                                JSONArray vOptions = jsonObject.getJSONArray("options");


                                for (int e = 0; e < vEquipments.length(); e++) {
                                    JSONObject jsonObjectEquiment = vEquipments.getJSONObject(e);
                                    Integer eid = Integer.parseInt(jsonObjectEquiment.getString("id"));
                                    String eName = jsonObjectEquiment.getString("nom");
                                    listeEquipement.add(new Equipement(eid, eName));
                                }

                                for (int o = 0; o < vOptions.length(); o++) {
                                    JSONObject jsonObjectOption = vOptions.getJSONObject(o);
                                    Integer oid = Integer.parseInt(jsonObject.getString("id"));
                                    String oName = jsonObjectOption.getString("nom");
                                    Integer oprix = Integer.parseInt(jsonObjectOption.getString("prix"));
                                    listeOptveh.add(new Optveh(oid, oName, oprix));


                                }
                                Vehicule vehicule = new Vehicule(vID, vName, vImage, vAvailable, vBaseDailyPrice, vSale, vAgeMin, vCO2Category, listeEquipement, listeOptveh);
                                listeVehicules.add(vehicule);

                                RecyclerView recyclerView = findViewById(R.id.liste_rechVec);
                                // à ajouter pour de meilleures performances :
                                recyclerView.setHasFixedSize(true);
                                // layout manager, décrivant comment les items sont disposés :
                                LinearLayoutManager layoutManager = new LinearLayoutManager(RechercheVecActivity.this);
                                recyclerView.setLayoutManager(layoutManager);
                                VehiculeViewAdapter coursesAdapter = new VehiculeViewAdapter(listeVehicules);
                                recyclerView.setAdapter(coursesAdapter);

                            }
                        } catch (Exception e) {
                            Log.i("RenduJson", "error" + String.valueOf(listeVehicules));

                            e.printStackTrace();
                        }
                        Log.i("RenduJson", "final" + String.valueOf(listeVehicules));
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers,
                                          byte[] errorResponse, Throwable e) {
                        Log.e("infoJson", e.toString());
                    }
                });
                LinearLayout parent = (LinearLayout)findViewById(R.id.parent);
                parent.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
            }
        });
    }
}
