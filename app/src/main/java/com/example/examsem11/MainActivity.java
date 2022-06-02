package com.example.examsem11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.examsem11.entities.Libro;
import com.example.examsem11.services.libroService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Exam11","onCreate");
        setContentView(R.layout.activity_main);

        //botones
        Button btnL = findViewById(R.id.btnListar);
        Button btnC = findViewById(R.id.btnCrear);

        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Actividad_Listar.class);
                startActivity(intent);
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Actividad_Crear.class);
                startActivity(intent);
            }
        });

    }
}