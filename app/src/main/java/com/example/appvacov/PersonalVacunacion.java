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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class PersonalVacunacion extends AppCompatActivity {
    public TextView textView4;
    public Button btn2,btn1;
    RequestQueue rq;

    public static final String EXTRA_MESSAGE = "message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_vacunacion);
        Intent intent = getIntent();
        String cedula = intent.getStringExtra(EXTRA_MESSAGE);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setText(cedula);
        btn2 = (Button) findViewById(R.id.button1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "http://192.168.0.227/appvacov/consulta_sede.php?cedula="+cedula, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            String sede;

                            try {
                                sede = response.getString("sede");
                                Intent intent = new Intent(PersonalVacunacion.this ,Citas.class);
                                intent.putExtra("sede",String.valueOf(sede));
                                intent.putExtra("cedula",String.valueOf(cedula));
                                startActivity(intent);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }

                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    }


                    );

                    rq = Volley.newRequestQueue(PersonalVacunacion.this);
                    rq.add(jsonObjectRequest);









            }
        });


    }

}
