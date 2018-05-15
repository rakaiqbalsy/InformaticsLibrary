package com.kelompok3.rplinformatika.informaticslibrary.JurnalActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.kelompok3.rplinformatika.informaticslibrary.Adapter.JurnalAdapter;
import com.kelompok3.rplinformatika.informaticslibrary.Model.Jurnal;
import com.kelompok3.rplinformatika.informaticslibrary.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivityJurnal extends AppCompatActivity {

    private final String JSON_JURNAL_URL = "https://gist.githubusercontent.com/rakaiqbalsy/0e10cc04a389889ff7d0e84e6ead7a1f/raw/a763ff2492955177f884ee3ef2feec0d19f9e2a1/ListJurnal.json";
    private JsonArrayRequest jurnalRequest;
    private RequestQueue requestQueueJurnal;
    private List<Jurnal> firstJurnal;
    private RecyclerView recyclerViewJurnal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_jurnal);

        firstJurnal = new ArrayList<>();

        recyclerViewJurnal = findViewById(R.id.recyclerViewJurnal);
        jsonJurnalRequest();
    }

    private void jsonJurnalRequest() {

        jurnalRequest = new JsonArrayRequest(JSON_JURNAL_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i=0; i<response.length(); i++) {

                    try{
                        jsonObject = response.getJSONObject(i);
                        Jurnal jurnal = new Jurnal();
                        jurnal.setJurnal(jsonObject.getString("Jurnal"));
                        jurnal.setKategoriJurnal(jsonObject.getString("kategoriJurnal"));
                        jurnal.setAuthor(jsonObject.getString("Author"));
                        jurnal.setCivitas(jsonObject.getString("civitasJurnal"));
                        jurnal.setTahunJurnal(jsonObject.getString("tahunJurnal"));
                        jurnal.setAbstrak(jsonObject.getString("Abstrak"));
                        jurnal.setSumberJurnal(jsonObject.getString("sumberJurnal"));
                        jurnal.setUrlJurnal(jsonObject.getString("linkJurnal"));
                        firstJurnal.add(jurnal);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setuprecyclerViewJurnal(firstJurnal);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueueJurnal = Volley.newRequestQueue(MainActivityJurnal.this);
        requestQueueJurnal.add(jurnalRequest);
    }

    private void setuprecyclerViewJurnal(List<Jurnal> firstJurnal) {

        JurnalAdapter myJurnalAdapter = new JurnalAdapter(this, firstJurnal);
        recyclerViewJurnal.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewJurnal.setAdapter(myJurnalAdapter);
    }
}
