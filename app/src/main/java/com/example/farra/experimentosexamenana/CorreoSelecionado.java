package com.example.farra.experimentosexamenana;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CorreoSelecionado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_correo_seleccionado);
        SeleccionadoFragment fragment = new SeleccionadoFragment();

        fragment.setPosition(getIntent().getExtras().getInt("POSITION",0));

        FragmentManager fragmentManager = getSupportFragmentManager();

         fragmentManager.beginTransaction()
                .add(R.id.correo_seleccion,fragment)
                .commit();



    }
}
