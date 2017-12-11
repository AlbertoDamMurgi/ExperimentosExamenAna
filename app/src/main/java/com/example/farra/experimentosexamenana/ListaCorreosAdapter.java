package com.example.farra.experimentosexamenana;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Farra on 11/12/2017.
 */

public class ListaCorreosAdapter extends ArrayAdapter<Correo> implements AdapterView.OnItemSelectedListener{

    private Context context;
    private ArrayList<Correo> datos;
    private Spinner familia,alumnos;
    public ListaCorreosAdapter(@NonNull Context context, @NonNull ArrayList<Correo> datos) {
        super(context, 0, datos);
        this.context=context;
        this.datos=datos;
    }

    class CorreoHolder {
        public ImageView imagen;
        public TextView asunto;
        public TextView remitente;
        public Spinner familia,alumnos;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()) {
            case R.id.sp_familia:

                TypedArray arrayAlumnos = getContext().getResources().obtainTypedArray(
                        R.array.alumnos_familia);
                CharSequence[] alumnos = arrayAlumnos.getTextArray(position);
                arrayAlumnos.recycle();


                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(
                        getContext(), android.R.layout.simple_spinner_item,
                        android.R.id.text1, alumnos);


                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


                this.alumnos.setAdapter(adapter);

                break;

            case R.id.sp_alumnos:

                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
            holder.familia = aux.findViewById(R.id.sp_familia);
            holder.alumnos = aux.findViewById(R.id.sp_alumnos);
            this.familia = holder.familia;
            this.alumnos = holder.alumnos;
            aux.setTag(holder);

        }

        holder = (CorreoHolder) aux.getTag();

        holder.imagen.setImageResource(datos.get(position).getImagencontacto());
        holder.asunto.setText(datos.get(position).getAsunto());
        holder.remitente.setText(datos.get(position).getRemitente());
        cargarFamilia();
        return aux;

    }

    private void cargarFamilia() {

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getContext(), R.array.familias, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        this.familia.setAdapter(adapter);

        // This activity implements the AdapterView.OnItemSelectedListener
        this.familia.setOnItemSelectedListener(this);
        this.alumnos.setOnItemSelectedListener(this);


    }
}
