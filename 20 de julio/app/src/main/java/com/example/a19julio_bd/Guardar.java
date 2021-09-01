package com.example.a19julio_bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Guardar extends AppCompatActivity {

    private TextView atv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar);

        atv1 = findViewById(R.id.tv1);

        String cod = getIntent().getStringExtra("cod");
        String nom = getIntent().getStringExtra("nom");
        String pre = getIntent().getStringExtra("pre");

        atv1.setText("Los datos ingresados son " +System.getProperty("line.separator")+
                System.getProperty("line.separator") +"Codigo: " + cod +
                System.getProperty("line.separator") +"Nombre: " + nom +
                System.getProperty("line.separator") + "Precio: " + pre);
    }

    public void volver(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}