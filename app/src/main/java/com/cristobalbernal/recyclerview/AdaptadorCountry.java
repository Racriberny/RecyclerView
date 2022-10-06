package com.cristobalbernal.recyclerview;

import static java.security.AccessController.getContext;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorCountry extends RecyclerView.Adapter<AdaptadorCountry.CountryViewFolder> {
    private final Country[] datos;

    public AdaptadorCountry(Country[] datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public CountryViewFolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_country,parent,false);
        return new CountryViewFolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewFolder holder, int position) {
        Country country = datos[position];
        holder.bindTitular(country);
    }

    @Override
    public int getItemCount() {
        return datos.length;
    }

    public static class CountryViewFolder extends RecyclerView.ViewHolder{
        private final ImageView imageView;
        private final TextView nombre;
        private final TextView capital;
        private final TextView poblacion;
        public CountryViewFolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nombre = itemView.findViewById(R.id.tvCountry);
            capital = itemView.findViewById(R.id.tvCapital);
            poblacion = itemView.findViewById(R.id.tvPoblacion);
        }

        public void bindTitular(Country country) {
            //falta imagen.
            nombre.setText(country.getCountry());
            capital.setText(country.getCapital());
            poblacion.setText(country.getPopulation());
        }
    }
}

