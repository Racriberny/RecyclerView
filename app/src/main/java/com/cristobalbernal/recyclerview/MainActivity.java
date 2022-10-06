package com.cristobalbernal.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Country[] datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarDatos();
        RecyclerView recyclerView = findViewById(R.id.rcView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new AdaptadorCountry(datos));
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }

    private void inicializarDatos() {
        CountryParser parser = new CountryParser(this);
        if(parser.parse()) {
           datos = parser.getCountries();
        } else {
            Toast.makeText(this, "No se pudieron obtener los datos de los países", Toast.LENGTH_SHORT).show();
        }
    }
}