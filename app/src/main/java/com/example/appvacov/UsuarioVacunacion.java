package com.example.appvacov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import android.os.Bundle;

public class UsuarioVacunacion extends AppCompatActivity {
    Button btn1, btn2, btn3;
    TextView textView3;
    public static final String EXTRA_MESSAGE = "message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_vacunacion);
        Intent intent = getIntent();
        String cedula = intent.getStringExtra(EXTRA_MESSAGE);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setText(cedula);
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
    }
}