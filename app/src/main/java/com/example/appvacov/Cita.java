package com.example.appvacov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Cita extends AppCompatActivity {

    RequestQueue rq;
    TextView textView,fecha, hora, id, sede;

    public static final String EXTRA_MESSAGE = "message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cita);
        Intent intent = getIntent();
        String cedula = intent.getStringExtra(EXTRA_MESSAGE);
        fecha = (TextView) findViewById(R.id.textView7);
        hora = (TextView) findViewById(R.id.textView6);
        id = (TextView) findViewById(R.id.textView8);
        sede = (TextView) findViewById(R.id.textView9);
        textView = (TextView) findViewById(R.id.textView5);
        textView.setText(cedula);
        consultar("http://192.168.1.8/appvacov/consulta_cita.php?usuario="+cedula);
    }
    private void consultar(String URL){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        hora.setText(jsonObject.getString("hora"));
                        fecha.setText(jsonObject.getString("fecha"));
                        id.setText(jsonObject.getString("id"));
                        sede.setText(jsonObject.getString("sede"));



                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();

                    }

                }
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