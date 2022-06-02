package com.example.examsem11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.examsem11.adapters.LibroAdapter;
import com.example.examsem11.entities.Libro;
import com.example.examsem11.services.libroService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Actividad_Listar extends AppCompatActivity {

    List<Libro> libros = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Exam11","onCreate");
        setContentView(R.layout.activity_actividad_listar2);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://628f5e820e69410599db36a5.mockapi.io/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        libroService service = retrofit.create(libroService.class);
        Call<List<Libro>> call = service.getLibro();

        call.enqueue(new Callback<List<Libro>>() {
            @Override
            public void onResponse(Call<List<Libro>> call, Response<List<Libro>> response) {
                if(!response.isSuccessful()){
                    Log.i("Exam11","Error de aplicacion");
                }else{
                    Log.i("APP_VJ20221","Respuesta correcta");
                    Log.i("APP_VJ20221",new Gson().toJson(response.body()));

                    //Obtencion de lista y envio al adapter
                    libros = response.body();

                    LibroAdapter adapter = new LibroAdapter(libros);
                    //Obtencion del recyclerview y envio del adapter
                    RecyclerView rv = findViewById(R.id.rvLista);
                    rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rv.setHasFixedSize(true);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Libro>> call, Throwable t) {
                Log.i("Exam11","No pudo conectar con el servicio");
            }
        });
    }
}