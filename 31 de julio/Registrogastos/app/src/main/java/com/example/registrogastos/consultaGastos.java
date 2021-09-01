package com.example.registrogastos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaParser;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class consultaGastos extends AppCompatActivity {


    ArrayList<String> listaServicios;
    ArrayList<detalleServicio> serviciosLista;
    private Spinner lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_gastos);

        lista = findViewById(R.id.spinner);

        consultarListaServicios();
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,listaServicios);
        lista.setAdapter(adaptador);
    }

    public void consultarListaServicios(){
        Admindb admin = new Admindb(this,"Registro",null,1);
        SQLiteDatabase base = admin.getWritableDatabase();

        detalleServicio s1 = null;
        serviciosLista = new ArrayList<detalleServicio>();

        Cursor fila = base.rawQuery("select * from registro_gastos",null);

        while(fila.moveToNext()){
            s1 = new detalleServicio();
            s1.setServicio(fila.getInt(0));
            s1.setMonto(fila.getInt(2));
            serviciosLista.add(s1);
            base.close();
            consultaServicio();
        }
    }

    public void consultaServicio(){
        listaServicios = new ArrayList<String>();
        for(int i = 0; i< serviciosLista.size();i++){
            listaServicios.add(serviciosLista.get(i).getServicio() + " - " +
                    serviciosLista.get(i).getFecha() + " - " +
                    serviciosLista.get(i).getMonto());
        }
    }

    public void volver(View v){
        Intent volver = new Intent(this,MainActivity.class);
        startActivity(volver);
    }
}
