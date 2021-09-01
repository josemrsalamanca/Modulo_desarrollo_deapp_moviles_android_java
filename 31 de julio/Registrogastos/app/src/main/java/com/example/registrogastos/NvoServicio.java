package com.example.registrogastos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NvoServicio extends AppCompatActivity {

    EditText nombre, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nvo_servicio);
        nombre = findViewById(R.id.etServicio);
        descripcion = findViewById(R.id.etDescripción);
    }

    public void crearServicio(View v){
        Admindb conex = new Admindb(this, "Gastos", null, 1);
        SQLiteDatabase bd = conex.getWritableDatabase();

        String nombre_servicio = nombre.getText().toString();
        String desc_servicio = descripcion.getText().toString();

        if(!nombre_servicio.isEmpty() && !desc_servicio.isEmpty()){
            ContentValues crear = new ContentValues();
            crear.put("nombre", nombre_servicio);
            crear.put("descripcion", desc_servicio);

            bd.insert("servicios", null, crear);
            bd.close();
            nombre.setText("");
            descripcion.setText("");
            Toast.makeText(this, "Servicio creado", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Ingrese todos los campos, son obligatorios", Toast.LENGTH_LONG).show();
        }
    }

    public void volver(View v){
        Intent welcomeBack = new Intent(this, registroGastos.class);
        startActivity(welcomeBack);
    }

}
