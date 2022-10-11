package com.cristobalbernal.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorCountry extends RecyclerView.Adapter<AdaptadorCountry.CountryViewFolder> {
    private final Country[] datos;
    private final Context context;

    public AdaptadorCountry(Country[] datos, Context context) {
        this.datos = datos;
        this.context = context;
    }

    @NonNull
    @Override
    public CountryViewFolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_country,parent,false);
        return new CountryViewFolder(itemView,context);
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
        private final Context context;
        public CountryViewFolder(@NonNull View itemView, Context context) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nombre = itemView.findViewById(R.id.tvCountry);
            capital = itemView.findViewById(R.id.tvCapital);
            poblacion = itemView.findViewById(R.id.tvPoblacion);
            this.context = context;
        }

        public void bindTitular(Country country) {
            try {
                String flagName = "_"+country.getCode().toLowerCase();
                int resID = context.getResources().getIdentifier(flagName,"drawable",context.getPackageName());
                if (resID !=0){
                    imageView.setImageResource(resID);
                }else {
                    flagName = "_onu";
                    resID = context.getResources().getIdentifier(flagName,"drawable",context.getPackageName());
                    imageView.setImageResource(resID);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            nombre.setText(country.getCountry());
            capital.setText(country.getCapital());
            poblacion.setText(country.getPopulation());
        }
    }
}

