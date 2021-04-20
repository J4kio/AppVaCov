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
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.widget.Toast;
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
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class AgendamientoCitas extends AppCompatActivity implements View.OnClickListener {
    EditText fecha, hora;
    Button btn1;
    Spinner spinner1;
    RequestQueue rq;
    private int mYear, mMonth, mDay, mHour, mMinute;
    TextView textView;
    public static final String EXTRA_MESSAGE = "message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamiento_citas);
        Intent intent = getIntent();
        String cedula = intent.getStringExtra(EXTRA_MESSAGE);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(cedula);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        btn1 = (Button) findViewById(R.id.button);
        fecha = (EditText) findViewById(R.id.editText1);
        hora = (EditText) findViewById(R.id.editText2);
        fecha.setOnClickListener(this);
        hora.setOnClickListener(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertar("http://192.168.0.227/appvacov/registro_cita.php");
            }
        });
    }

            @Override
            public void onClick(View v) {
                if (v == fecha) {
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

                                    fecha.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

                                }
                            }, mYear, mMonth, mDay);
                    datePickerDialog.show();
                }
                if (v == hora) {

                    // Get Current Time
                    final Calendar c = Calendar.getInstance();

                    mHour = c.get(Calendar.HOUR_OF_DAY);
                    mMinute = c.get(Calendar.MINUTE);

                    // Launch Time Picker Dialog
                    TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                            new TimePickerDialog.OnTimeSetListener() {

                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    hora.setText(hourOfDay + ":" + minute);
                                }

                            }, mHour, mMinute, false);
                    timePickerDialog.show();

                }
            }
    private void insertar(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>(){
            @Override
            public void onResponse (String Response){
                Toast.makeText(getApplicationContext(),"Cita Registrada", Toast.LENGTH_LONG).show();

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
                parametros.put("fecha", fecha.getText().toString());
                parametros.put("hora", hora.getText().toString());
                parametros.put("sede", spinner1.getSelectedItem().toString());
                parametros.put("usuario", textView.getText().toString());
                return parametros;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

        }
