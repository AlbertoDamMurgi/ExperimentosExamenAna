package com.example.farra.experimentosexamenana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<Correo> correos = new ArrayList<>();

    public static ArrayList<Correo> getCorreos() {
        return correos;
    }

    public static void setCorreos(ArrayList<Correo> correos) {
        MainActivity.correos = correos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            rellenarDatos();



        ListView lista = (ListView) findViewById(R.id.list);

        ListaCorreosAdapter adapter = new ListaCorreosAdapter(getApplicationContext(),correos);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),CorreoSelecionado.class);
                Bundle bundle = new Bundle();
                bundle.putInt("POSITION",position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }



    private void rellenarDatos() {
        if(correos.isEmpty()) {
            correos.add(new Correo("farrator@gmail.com", "probando1", "si vas pa la mar pa la mar si vas pa la mar.", R.drawable.head1));
            correos.add(new Correo("farra@gmail.com", "probando2", "si vas ", R.drawable.head2));
            correos.add(new Correo("farratorcin@gmail.com", "probando3", "si vas pa la mar ", R.drawable.head3));
            correos.add(new Correo("farratorcillo@gmail.com", "probando4", "ay que te como,  ay que te voy a comer", R.drawable.head4));
            correos.add(new Correo("farrator5@gmail.com", "probando5", "mar.", R.drawable.head5));
            correos.add(new Correo("farrator6@gmail.com", "probando6", "si vas pa", R.drawable.head6));
            correos.add(new Correo("farrator@gmail.com", "probando7", "si vas pa la mar pa la mar si vas pa la mar.", R.drawable.head1));
            correos.add(new Correo("farra@gmail.com", "probando8", "si vas ", R.drawable.head2));
            correos.add(new Correo("farratorcin@gmail.com", "probando9", "si vas pa la mar ", R.drawable.head3));
            correos.add(new Correo("farratorcillo@gmail.com", "probando10", "pa la mar.", R.drawable.head4));
            correos.add(new Correo("farrator5@gmail.com", "probando11", "mar.", R.drawable.head5));
            correos.add(new Correo("farrator6@gmail.com", "probando12", "si vas pa", R.drawable.head6));
        }
    }


}
