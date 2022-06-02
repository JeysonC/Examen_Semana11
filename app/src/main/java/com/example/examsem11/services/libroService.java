package com.example.examsem11.services;

import com.example.examsem11.entities.Libro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface libroService {
    @GET("libros")
    Call<List<Libro>> getLibro();

    @POST("libros")
    Call<Libro> crearLibro(@Body Libro libro);
}
