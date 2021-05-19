package com.example.appvacov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConsultaFase extends AppCompatActivity {
    private Button consultar;
    private Spinner spinnerfase;
    List<ListElement3> elements3;
    RequestQueue rq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_fase);
        consultar = findViewById(R.id.button4);
        spinnerfase = findViewById(R.id.spinnerfase);



        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                consultar ("http://192.168.0.227/appvacov/consulta_fase.php?fase="+spinnerfase.getSelectedItem().toString());

            }
        });



    }
    private void consultar(String URL){
        elements3 = new ArrayList<>();


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);

                        elements3.add(new ListElement3(jsonObject.getString("cedula"), jsonObject.getString("correo"), jsonObject.getString("nombres"), jsonObject.getString("apellidos"), jsonObject.getString("edad"),jsonObject.getString("genero"),jsonObject.getString("fase"),jsonObject.getString("ocupacion"),jsonObject.getString("comorbilidades"),jsonObject.getString("direccion")));

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();

                    }

                }



                ListAdapter3 listAdapter3 = new ListAdapter3(elements3,ConsultaFase.this);
                RecyclerView recyclerView = findViewById(R.id.recyclerView5);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(ConsultaFase.this));
                recyclerView.setAdapter(listAdapter3);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "No hay Datos", Toast.LENGTH_LONG).show();
            }
        });
        rq = Volley.newRequestQueue(this);
        rq.add(jsonArrayRequest);




    }
}