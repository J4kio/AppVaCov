package com.example.appvacov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ReporteVacunacion extends AppCompatActivity {

   private TextView cedula_paciente_reporte,cedula_personal_reporte,fecha_reporte,sede_reporte;
   private Button btn;
   private EditText lote_reporte;
   private Spinner marca_reporte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_vacunacion);
        Bundle extras = getIntent().getExtras();
        String sede = "";
        String fecha = "";
        String usuario = "";
        String cedulap="";

         if (extras!=null){

             sede = extras.getString("sede");
             fecha = extras.getString("fecha");
             usuario = extras.getString("usuario");
             cedulap = extras.getString("cedulap");

        }


        cedula_paciente_reporte =findViewById(R.id.cedula_paciente_reporte);
        cedula_personal_reporte = findViewById(R.id.cedula_personal_reporte);
        fecha_reporte = findViewById(R.id.fecha_reporte);
        sede_reporte = findViewById(R.id.sede_reporte);
        lote_reporte = findViewById(R.id.lote_reporte);
        marca_reporte = findViewById(R.id.marca_reporte);

        cedula_paciente_reporte.setText(usuario);
        cedula_personal_reporte.setText(cedulap);
        fecha_reporte.setText(fecha);
        sede_reporte.setText(sede);

        btn = findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            ejecutarServicio("http://192.168.0.227/appvacov/registro_reporte_vacunacion.php");
            actualizar("http://192.168.0.227/appvacov/aplicar_vacuna.php?id_lote="+lote_reporte.getText().toString());

            }
        });

    }
    private void ejecutarServicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>(){
            @Override
            public void onResponse (String Response){
                Toast.makeText(getApplicationContext(),"Reporte Registrado", Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse (VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }

        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("cedulapa",  cedula_paciente_reporte.getText().toString() );
                parametros.put("cedulap",  cedula_personal_reporte.getText().toString());
                parametros.put("fecha", fecha_reporte.getText().toString());
                parametros.put("sede", sede_reporte.getText().toString());
                parametros.put("id_lote", lote_reporte.getText().toString());
                parametros.put("marca", marca_reporte.getSelectedItem().toString());

                return parametros;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    private void actualizar(String URL){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getApplicationContext(), "Registro Actualizado", Toast.LENGTH_LONG).show();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        }


        );

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);

    }
}