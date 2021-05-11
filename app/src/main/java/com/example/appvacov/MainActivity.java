package com.example.appvacov;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity {
    public static final String EXTRA_MESSAGE = "message";

    Button btn1,btn2;
    Spinner spinner1;
    EditText editText1,editText2;
    RequestQueue rq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        btn1 = (Button) findViewById(R.id.button1);
        rq = Volley.newRequestQueue(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                 if(spinner1.getSelectedItem().toString().equals("Usuario de Vacunación")) {

                     login("http://192.168.0.227/appvacov/login_usuario_vacunacion.php?cedula="+editText1.getText().toString()+"&clave="+editText2.getText().toString(),"usuario_vacunacion");


                }
                else if (spinner1.getSelectedItem().toString().equals("Personal de Vacunación")){
                     login("http://192.168.0.227/appvacov/login_personal_vacunacion.php?cedula="+editText1.getText().toString()+"&clave="+editText2.getText().toString(),"personal_vacunacion");

                }
                else if (spinner1.getSelectedItem().toString().equals("Representante de sitio de Vacunación")){

                     login("http://192.168.0.227/appvacov/login_representante_sitio_vacunacion.php?cedula="+editText1.getText().toString()+"&clave="+editText2.getText().toString(),"representante");

                }
                else if (spinner1.getSelectedItem().toString().equals("Receptor y Distribuidor de Vacunas")){

                     login("http://192.168.0.227/appvacov/login_admin_vacunas.php?cedula="+editText1.getText().toString()+"&clave="+editText2.getText().toString(),"receptor");
                }

                
            }
        });

         btn2 = (Button) findViewById(R.id.button2);
         btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(spinner1.getSelectedItem().toString().equals("Usuario de Vacunación")) {
                startActivity(new Intent(MainActivity.this, RegistroUsuario.class));

            }
            else if (spinner1.getSelectedItem().toString().equals("Personal de Vacunación")){
                startActivity(new Intent(MainActivity.this, RegistroPersonalVacunacion.class));

            }
            else if (spinner1.getSelectedItem().toString().equals("Representante de sitio de Vacunación")){

                startActivity(new Intent(MainActivity.this, RegistroRepresentanteSitioVacunacion.class));

            }
            else if (spinner1.getSelectedItem().toString().equals("Receptor y Distribuidor de Vacunas")){
                startActivity(new Intent(MainActivity.this, RegistroAdminVacunas.class));

            }
        }
    });


    }

    private void login(String URL, String usuario){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                int cedula;
                int fase;

                try {
                    cedula = Integer.parseInt(response.getString("cedula"));
                    if (usuario.equals("usuario_vacunacion")) {


                        fase = Integer.parseInt(response.getString("fase"));

                        Intent intent = new Intent(MainActivity.this ,UsuarioVacunacion.class);
                        intent.putExtra(UsuarioVacunacion.EXTRA_MESSAGE,String.valueOf(cedula)+"-"+String.valueOf(fase));
                        startActivity(intent);

                    }
                    else if (usuario.equals("personal_vacunacion")){
                        Intent intent = new Intent(MainActivity.this ,PersonalVacunacion.class);
                        intent.putExtra(PersonalVacunacion.EXTRA_MESSAGE,String.valueOf(cedula));
                        startActivity(intent);


                    }
                    else if (usuario.equals("representante")){

                        startActivity(new Intent(MainActivity.this, RepresentanteSitioVacunacion.class));

                    }
                    else if (usuario.equals("receptor")){

                        Intent intent = new Intent(MainActivity.this ,AdminVacunas.class);
                        intent.putExtra(AdminVacunas.EXTRA_MESSAGE,String.valueOf(cedula));
                        startActivity(intent);

                       //startActivity(new Intent(MainActivity.this, AdminVacunas.class));
                    }
                    Toast.makeText(getApplicationContext(), "Log In" , Toast.LENGTH_LONG).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Usuario o Clave Incorrecto", Toast.LENGTH_LONG).show();
            }
        }


        );
        rq = Volley.newRequestQueue(this);
        rq.add(jsonObjectRequest);


    }


}