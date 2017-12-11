package com.example.farra.experimentosexamenana;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Farra on 11/12/2017.
 */

public class ListaCorreosAdapter extends ArrayAdapter<Correo> {

    private Context context;
    private ArrayList<Correo> datos;

    public ListaCorreosAdapter(@NonNull Context context, @NonNull ArrayList<Correo> datos) {
        super(context, 0, datos);
        this.context=context;
        this.datos=datos;
    }

    class CorreoHolder {
        public ImageView imagen;
        public TextView asunto;
        public TextView remitente;


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View aux = convertView;
        CorreoHolder holder;
        if(aux==null){

            aux = LayoutInflater.from(context).inflate(R.layout.esqueleto,parent,false);

            holder=new CorreoHolder();
            holder.imagen = aux.findViewById(R.id.imagen_lista);
            holder.asunto = aux.findViewById(R.id.tv_asunto_fragmento);
            holder.remitente = aux.findViewById(R.id.tv_remitente_lista);

            aux.setTag(holder);

        }

        holder = (CorreoHolder) aux.getTag();

        holder.imagen.setImageResource(datos.get(position).getImagencontacto());
        holder.asunto.setText(datos.get(position).getAsunto());
        holder.remitente.setText(datos.get(position).getRemitente());

        return aux;

    }
}
