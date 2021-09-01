package com.example.a19julio_bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Buscar extends AppCompatActivity {

    private TextView atv2;
    private Spinner sspiner;

    ArrayList<String> listaProductos;
    ArrayList<Producto> productosLista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        atv2 = findViewById(R.id.tv2);

        String cod = getIntent().getStringExtra("cod");
        String nom = getIntent().getStringExtra("nom");
        String pre = getIntent().getStringExtra("pre");


        atv2.setText("El registro encontrado es: " + System.getProperty("line.separator") +
                System.getProperty("line.separator") + "Codigo: " + cod +
                System.getProperty("line.separator") + "Nombre: " + nom +
                System.getProperty("line.separator") + "Precio: " + pre);


        sspiner = findViewById(R.id.spinner);

        consultarListaProductos();

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,listaProductos);
        sspiner.setAdapter(adaptador);

    }

    public void consultarListaProductos(){
        Admindb admin = new Admindb(this,"Productos",null,1);
        SQLiteDatabase base = admin.getWritableDatabase();

        Producto p1 = null;
        productosLista = new ArrayList<Producto>();

        Cursor fila = base.rawQuery("select * from producto",null);

        while(fila.moveToNext()){
            p1 = new Producto();
            p1.setCodigo(fila.getInt(0));
            p1.setNombre(fila.getString(1));
            p1.setPrecio(fila.getInt(2));
            productosLista.add(p1);
            base.close();
            consultarproducto();
        }
    }

    public void consultarproducto(){
        listaProductos = new ArrayList<String>();
        for (int i=0;i< productosLista.size();i++){
            listaProductos.add(productosLista.get(i).getCodigo() + " - " +
                    productosLista.get(i).getNombre() + " - " +
                    productosLista.get(i).getPrecio());
        }
    }

    public void volver(View v){
        Intent volver = new Intent(this,MainActivity.class);
        startActivity(volver);
    }
}