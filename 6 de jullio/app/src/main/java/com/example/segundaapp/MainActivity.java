package com.example.segundaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvr;
    private EditText edmun1,edmun2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edmun1 = findViewById(R.id.editnumero1);
        edmun2 = findViewById(R.id.editnumero2);
        tvr= findViewById(R.id.tvresultado);
    }

    public void sumar(View v){
        int valor1 = Integer.parseInt(edmun1.getText().toString());
        int valor2 = Integer.parseInt(edmun2.getText().toString());
        int suma = valor1+valor2;
        tvr.setText("El resultado de la suma es:"+suma);
    }
}