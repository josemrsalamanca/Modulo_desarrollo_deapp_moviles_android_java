package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saludar(View v){
        Toast.makeText(this, "Hola soy un botón", Toast.LENGTH_LONG).show();
    }

    public void saludar2(View v){
        Toast.makeText(this, "Hola soy otro botón", Toast.LENGTH_LONG).show();
    }
}