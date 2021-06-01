package com.example.appvacov;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class AgregarVacunas extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_MESSAGE = "message";
    public EditText editText1,editText2,cantidad_registro,fecha1,fecha2;
    public Spinner spinner1;
    private int mYear, mMonth, mDay;
    public Button btn1;
    public String conexion = "192.168.1.8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_vacunas);
        Intent intent = getIntent();
        String cedula = intent.getStringExtra(EXTRA_MESSAGE);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText1.setText(cedula);
        editText2 = (EditText) findViewById(R.id.editText2);
        cantidad_registro = (EditText) findViewById(R.id.cantidad_registro);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        fecha1 = (EditText) findViewById(R.id.editText4);
        fecha1.setOnClickListener(this);
        fecha2 = (EditText) findViewById(R.id.editText5);
        fecha2.setOnClickListener(this);

        btn1 = (Button) findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertar("http://192.168.1.8/appvacov/registro_vacuna.php");
            }
        });


    }

    private void insertar(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>(){
            @Override
            public void onResponse (String Response){
                Toast.makeText(getApplicationContext(),"Vacuna registrada", Toast.LENGTH_LONG).show();

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
                parametros.put("cantidad", cantidad_registro.getText().toString());
                parametros.put("fecha_de_recepcion", fecha1.getText().toString());
                parametros.put("marca", spinner1.getSelectedItem().toString());
                parametros.put("fecha_vencimiento", fecha2.getText().toString());
                parametros.put("id_lote", editText2.getText().toString());
                parametros.put("cedula", editText1.getText().toString());
                return parametros;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



    @Override
    public void onClick(View v) {

        if (v == fecha1) {
            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            fecha1.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();

        }
        else if (v == fecha2){
            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            fecha2.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();

        }
    }
}