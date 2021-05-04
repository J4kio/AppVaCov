package com.example.appvacov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class AdminVacunas extends AppCompatActivity {
    public Button btn2,btn1,btn3;
    public TextView textView3;
    public static final String EXTRA_MESSAGE = "message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_vacunas);
        Intent intent = getIntent();
        String cedula = intent.getStringExtra(EXTRA_MESSAGE);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setText(cedula);
        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminVacunas.this ,AgregarVacunas.class);
                intent.putExtra(AgregarVacunas.EXTRA_MESSAGE,String.valueOf(cedula));
                startActivity(intent);
            }
        });
        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminVacunas.this, AsignarVacuna.class));
            }
        });
        btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(AdminVacunas.this, RegistroPersonalVacunacion.class));

            }
        });
    }
}