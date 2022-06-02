package com.example.examsem11.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examsem11.R;
import com.example.examsem11.entities.Libro;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LibroAdapter extends RecyclerView.Adapter<LibroAdapter.StringViewHolder> {
    List<Libro> libros;

    public LibroAdapter(List<Libro> libros) {
        this.libros = libros;
    }

    @NonNull
    @Override
    public LibroAdapter.StringViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_libro,parent,false);
        StringViewHolder vh = new StringViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull LibroAdapter.StringViewHolder vh, int position) {
        View view = vh.itemView;
        Libro libro =libros.get(position);
        TextView tvLibroName = view.findViewById(R.id.tvTitulo);
        ImageView imageView = view.findViewById(R.id.ivImagen);

        View Ly = view.findViewById(R.id.lEsquema);

        tvLibroName.setText(libro.titulo);

        Picasso.get()
                .load(libro.imagen)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.stat_notify_error)
                .into(imageView);
        Ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return libros.size();
    }

    public class StringViewHolder extends RecyclerView.ViewHolder {
        public StringViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
