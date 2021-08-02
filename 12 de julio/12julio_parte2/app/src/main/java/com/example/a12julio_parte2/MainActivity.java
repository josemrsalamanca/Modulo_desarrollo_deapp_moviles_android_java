package com.example.a12julio_parte2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.tv1);
    }

    public void calculadora(View v){
        Intent calculadora = new Intent(this,Dividir.class);
        calculadora.putExtra("calcular",tv1.getText().toString());
        startActivity(calculadora);
    }
}