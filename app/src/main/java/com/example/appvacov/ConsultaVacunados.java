package com.example.appvacov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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

public class ConsultaVacunados extends AppCompatActivity {
    List<ListElement2> elements2;
    RequestQueue rq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_vacunados);


        consultar ("http://192.168.0.227/appvacov/consulta_vacunados.php");
    }
    private void consultar(String URL){
        elements2 = new ArrayList<>();


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);

                        elements2.add(new ListElement2(jsonObject.getString("nombres"), jsonObject.getString("apellidos"), jsonObject.getString("cedula"), jsonObject.getString("fecha_vacunacion"), jsonObject.getString("dosis"),jsonObject.getString("fase"),jsonObject.getString("edad")));

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();

                    }

                }



                ListAdapter2 listAdapter2 = new ListAdapter2(elements2,ConsultaVacunados.this);
                RecyclerView recyclerView = findViewById(R.id.recyclerView2);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(ConsultaVacunados.this));
                recyclerView.setAdapter(listAdapter2);


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