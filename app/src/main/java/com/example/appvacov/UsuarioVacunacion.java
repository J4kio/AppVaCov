package com.example.appvacov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class UsuarioVacunacion extends AppCompatActivity {
    Button btn1, btn2, btn3;
    TextView textView3,textView5;
    RequestQueue rq;
    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_vacunacion);
        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        String[] parts = message.split("-");
        textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setText(parts[0]);//0 = cedula

        textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setText(parts[1]); // 1 = fase
        rq = Volley.newRequestQueue(this);
        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(UsuarioVacunacion.this, AgendamientoCitas.class));

                Intent intent = new Intent(UsuarioVacunacion.this ,AgendamientoCitas.class);
                intent.putExtra(UsuarioVacunacion.EXTRA_MESSAGE,textView3.getText().toString());
                startActivity(intent);

            }
        });

        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UsuarioVacunacion.this ,Cita.class);
                intent.putExtra(UsuarioVacunacion.EXTRA_MESSAGE,textView3.getText().toString());
                startActivity(intent);

            }
        });
        btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            eliminar_cita("http://192.168.0.227/appvacov/eliminar_cita.php?cedula="+textView3.getText());
                Toast.makeText(getApplicationContext(),"Cita Eliminada", Toast.LENGTH_LONG).show();


            }
        });

    }
    private void eliminar_cita(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>(){
            @Override
            public void onResponse (String Response){
                Toast.makeText(getApplicationContext(),"Cita eliminada", Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse (VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }

        });
        rq = Volley.newRequestQueue(this);
        rq.add(stringRequest);
    }
}