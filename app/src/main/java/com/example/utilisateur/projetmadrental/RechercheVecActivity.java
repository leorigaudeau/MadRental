package com.example.utilisateur.projetmadrental;

import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class RechercheVecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_vec);
        // client HTTP :
        AsyncHttpClient client = new AsyncHttpClient();
        // paramètres :
        RequestParams requestParams = new RequestParams();
        requestParams.put("parametre", "1234");
        // appel :
        client.post("http://s519716619.onlinehome.fr/exchange/madrental/get-vehicules.php", requestParams, new AsyncHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response)
            {
                String retour = new String(response);
                Gson gson = new Gson();
                List<Vehicule> listeVehicules = new ArrayList<>();
                try
                {
                    JSONArray jsonArray = new JSONArray(retour);
                    for (int i = 0 ; i < jsonArray.length() ; i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Vehicule vehicule = gson.fromJson(jsonObject.toString(), Vehicule.class);
                        listeVehicules.add(vehicule);

                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers,
                                  byte[] errorResponse, Throwable e)
            {
                Log.e("infoJson", e.toString());
            }
        });

    }


}
