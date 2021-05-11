package com.example.appvacov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RepresentanteSitioVacunacion extends AppCompatActivity {
    Button btn1, btn2, btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_representante_sitio_vacunacion);


        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(UsuarioVacunacion.this, AgendamientoCitas.class));

               /** Intent intent = new Intent(UsuarioVacunacion.this ,AgendamientoCitas.class);
                intent.putExtra(UsuarioVacunacion.EXTRA_MESSAGE,textView3.getText().toString());
                startActivity(intent);**/

            }
        });

        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**Intent intent = new Intent(UsuarioVacunacion.this ,Cita.class);
                intent.putExtra(UsuarioVacunacion.EXTRA_MESSAGE,textView3.getText().toString());
                startActivity(intent);**/

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