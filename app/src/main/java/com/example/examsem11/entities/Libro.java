package com.example.examsem11.entities;

public class Libro {
    public int id;
    public String titulo;
    public String resumen;
    public String autor;
    public String fecha_publicacion;
    public String tienda_1;
    public String tienda_2;
    public String tienda_3;
    public String imagen;

    public Libro() {
    }

    public Libro(String titulo, String resumen, String autor, String fecha_publicacion, String tienda_1, String tienda_2, String tienda_3, String imagen) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.autor = autor;
        this.fecha_publicacion = fecha_publicacion;
        this.tienda_1 = tienda_1;
        this.tienda_2 = tienda_2;
        this.tienda_3 = tienda_3;
        this.imagen = imagen;
    }

    public Libro(int id, String titulo, String resumen, String autor, String fecha_publicacion, String tienda_1, String tienda_2, String tienda_3, String imagen) {
        this.id = id;
        this.titulo = titulo;
        this.resumen = resumen;
        this.autor = autor;
        this.fecha_publicacion = fecha_publicacion;
        this.tienda_1 = tienda_1;
        this.tienda_2 = tienda_2;
        this.tienda_3 = tienda_3;
        this.imagen = imagen;
    }
}
