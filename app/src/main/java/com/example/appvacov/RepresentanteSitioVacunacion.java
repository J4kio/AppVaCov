package com.example.appvacov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RepresentanteSitioVacunacion extends AppCompatActivity {
    Button btn1, btn2, btn3;
    TextView textView10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_representante_sitio_vacunacion);


        Bundle extras = getIntent().getExtras();
        String cedula = extras.getString("cedula");

        textView10 = findViewById(R.id.textView10);
        textView10.setText(cedula);
        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RepresentanteSitioVacunacion.this ,ConsultaFase.class);
                startActivity(intent);

            }
        });

        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RepresentanteSitioVacunacion.this ,ConsultaSegundaDosis.class);
                startActivity(intent);

            }
        });
        btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RepresentanteSitioVacunacion.this ,ConsultaVacunados.class);
                startActivity(intent);



            }
        });



    }
}