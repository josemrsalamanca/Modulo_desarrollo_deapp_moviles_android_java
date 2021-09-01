package com.example.registrogastos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goGastos(View v){
        Intent gastos = new Intent(this,registroGastos.class);
        startActivity(gastos);
    }

    public void goConsulta(View v){
        Intent consulta = new Intent(this,consultaGastos.class);
        startActivity(consulta);
    }

    public void goCompara(View v){
        Intent compara = new Intent(this,comparar.class);
        startActivity(compara);
    }

}