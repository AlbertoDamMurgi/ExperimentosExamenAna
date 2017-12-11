package com.example.farra.experimentosexamenana;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SeleccionadoFragment extends Fragment {


    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public SeleccionadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View aux = inflater.inflate(R.layout.fragment_correo_seleccionado, container, false);



        TextView remitente = (TextView) aux.findViewById(R.id.tv_remitente_fragment);
        TextView asunto = (TextView) aux.findViewById(R.id.tv_asunto_fragmento);
        TextView contenido = (TextView) aux.findViewById(R.id.tv_contenido_fragment);

        remitente.setText(MainActivity.getCorreos().get(position).getRemitente());
        asunto.setText(MainActivity.getCorreos().get(position).getAsunto());
        contenido.setText(MainActivity.getCorreos().get(position).getContenido());

        return aux;

    }

}
