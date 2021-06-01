package com.example.appvacov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Citas extends AppCompatActivity  {
    List<ListElement> elements;
    public TextView textView4,cedula_personal_citas;

    RequestQueue rq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);
        Intent intent = getIntent();

        String sede = intent.getStringExtra("sede");
        String cedula = intent.getStringExtra("cedula");

        textView4 = (TextView) findViewById(R.id.textview4);
        textView4.setText(sede);
        cedula_personal_citas = (TextView) findViewById(R.id.cedula_personal_citas);
        cedula_personal_citas.setText(cedula);

        consultar ("http://192.168.1.8/appvacov/consulta_citas.php?sede="+textView4.getText().toString());



    }
    private void consultar(String URL){
        elements = new ArrayList<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);

                      elements.add(new ListElement(jsonObject.getString("id"), jsonObject.getString("hora"), jsonObject.getString("fecha"), jsonObject.getString("sede"), jsonObject.getString("usuario"),cedula_personal_citas.getText().toString()));

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();

                    }

                }
                ListAdapter listAdapter = new ListAdapter(elements,Citas.this);
                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(Citas.this));
                recyclerView.setAdapter(listAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        });
        rq = Volley.newRequestQueue(this);
        rq.add(jsonArrayRequest);




    }

}