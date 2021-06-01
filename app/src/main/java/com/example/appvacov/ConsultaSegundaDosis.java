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

public class ConsultaSegundaDosis extends AppCompatActivity {
    List<ListElement2> elements2;
    RequestQueue rq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_segunda_dosis);

        consultar ("http://192.168.1.8/appvacov/consulta_segunda_dosis.php");
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

                        elements2.add(new ListElement2(jsonObject.getString("id_reporte"), jsonObject.getString("cedula_paciente"), jsonObject.getString("cedula_personal"), jsonObject.getString("fecha_vacunacion"), jsonObject.getString("sede"),jsonObject.getString("dosis"),jsonObject.getString("id_lote"),jsonObject.getString("marca")));

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();

                    }

                }



                ListAdapter2 listAdapter2 = new ListAdapter2(elements2,ConsultaSegundaDosis.this);
                RecyclerView recyclerView = findViewById(R.id.recyclerView4);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(ConsultaSegundaDosis.this));
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