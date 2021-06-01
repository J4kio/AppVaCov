package com.example.appvacov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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

public class VerInventario extends AppCompatActivity {
    List<ListElement4> elements4;
    RequestQueue rq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_inventario);

        consultar ("http://192.168.1.8/appvacov/consulta_inventario_general.php");
    }
    private void consultar(String URL){
        elements4 = new ArrayList<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);

                        elements4.add(new ListElement4(jsonObject.getString("id_lote"), jsonObject.getString("fecha_vencimiento"), jsonObject.getString("marca"), jsonObject.getString("fecha_de_recepcion"), jsonObject.getString("cantidad")));

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();

                    }

                }
                ListAdapter4 listAdapter4 = new ListAdapter4(elements4,VerInventario.this);
                RecyclerView recyclerView = findViewById(R.id.recyclerView6);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(VerInventario.this));
                recyclerView.setAdapter(listAdapter4);

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