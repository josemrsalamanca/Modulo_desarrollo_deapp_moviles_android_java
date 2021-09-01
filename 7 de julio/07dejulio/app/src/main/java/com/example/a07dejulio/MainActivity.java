package com.example.a07dejulio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edTNumero1, edTNumero2;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTNumero1 = findViewById(R.id.edTNumero2);
        edTNumero2 = findViewById(R.id.edtNumero1);
        tvResult = findViewById(R.id.tvResult);
    }
    public void sumar(View v) {
        int valor1 = Integer.parseInt(edTNumero1.getText().toString());
        int valor2 = Integer.parseInt(edTNumero2.getText().toString());
        int suma = valor1 + valor2;
        tvResult.setText("El resultado es:" + suma);
    }

    public void restar(View v) {
        int valor1 = Integer.parseInt(edTNumero1.getText().toString());
        int valor2 = Integer.parseInt(edTNumero2.getText().toString());
        int resta = valor1 - valor2;
        tvResult.setText("El resultado es:" + resta);

    }
    public void Mult(View v) {
        int valor1 = Integer.parseInt(edTNumero1.getText().toString());
        int valor2 = Integer.parseInt(edTNumero2.getText().toString());
        int Mult = valor1 * valor2;
        tvResult.setText("El resultado es:" + Mult);
    }
    public void Div(View v) {
        int valor1 = Integer.parseInt(edTNumero1.getText().toString());
        int valor2 = Integer.parseInt(edTNumero2.getText().toString());
        if (valor2<=0){
            tvResult.setText("No se puede dividir por 0");} else {
            int Div= valor1/valor2;
            tvResult.setText("El resultado es: "+Div);}
    }
}











