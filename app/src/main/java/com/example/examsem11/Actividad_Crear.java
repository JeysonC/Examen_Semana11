package com.example.examsem11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.examsem11.entities.Libro;
import com.example.examsem11.services.libroService;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Actividad_Crear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Exam11","onCreate");
        setContentView(R.layout.activity_actividad_crear);

        Button btnCrear = findViewById(R.id.btnCrear);
        EditText ettitulo= findViewById(R.id.ingresarTitulo);
        EditText etresumen = findViewById(R.id.ingresarResumen);
        EditText etautor = findViewById(R.id.ingresarAutor);
        EditText etfecha = findViewById(R.id.ingresarFecha);
        EditText ettienda1 = findViewById(R.id.ingresarTienda1);
        EditText ettienda2 = findViewById(R.id.ingresarTienda2);
        EditText ettienda3 = findViewById(R.id.ingresarTienda3);
        EditText etimagen = findViewById(R.id.ingresarImagen);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://628f5e820e69410599db36a5.mockapi.io/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libroService service = retrofit.create(libroService.class);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Libro libro = new Libro();
                libro.titulo= String.valueOf(ettitulo.getText());
                libro.resumen = String.valueOf(etresumen.getText());
                libro.autor =String.valueOf( etautor.getText());
                libro.fecha_publicacion =String.valueOf( etfecha.getText());
                libro.tienda_1 =String.valueOf( ettienda1.getText());
                libro.tienda_2 =String.valueOf( ettienda2.getText());
                libro.tienda_3 =String.valueOf( ettienda3.getText());
                libro.imagen =String.valueOf( etimagen.getText());

                Call<Libro> call = service.crearLibro(libro);

                call.enqueue(new Callback<Libro>() {
                    @Override
                    public void onResponse(Call<Libro> call, Response<Libro> response) {
                        if (response.isSuccessful()){
                            Log.i("Exam11",new Gson().toJson(response.body()));

                            Intent intent = new Intent(getApplicationContext(),Actividad_Listar.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<Libro> call, Throwable t) {
                        Log.i("Exam11","No se hizo la conexion");
                    }
                });

            }
        });
    }




}