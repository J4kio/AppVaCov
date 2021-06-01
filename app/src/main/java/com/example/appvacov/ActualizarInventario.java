package com.example.appvacov;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Calendar;

public class ActualizarInventario extends AppCompatActivity implements View.OnClickListener {

    EditText fechar, fechav,id_lote,cantidad;
    Button btn;
    Spinner spinner1;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_inventario);

        spinner1 = (Spinner)findViewById(R.id.Aspinner);
        btn = (Button) findViewById(R.id.button5);
        fechar= (EditText)findViewById(R.id.Afechar);
        fechav= (EditText)findViewById(R.id.Afechav);
        id_lote= (EditText)findViewById(R.id.Aid_lote);
        cantidad= (EditText)findViewById(R.id.Acantidad);
        fechar.setOnClickListener(this);
        fechav.setOnClickListener(this);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                actualizar("http://192.168.1.8/appvacov/actualizacion_inventario_general.php?cantidad="+cantidad.getText()+ "&id_lote="+id_lote.getText()+"&fechar="+fechar.getText()+"&fechav="+fechav.getText()+"&marca="+spinner1.getSelectedItem().toString());


            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v == fechar) {
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

                            fechar.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();

        }
        else if (v == fechav){
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

                            fechav.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();

        }
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

            }
        }


        );

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);

    }
}