package com.example.swich;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv;
    private Switch sw1, sw2, sw3, sw4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.edit1);
        et2 = findViewById(R.id.edit2);
        sw1 = findViewById(R.id.switch1);
        sw2 = findViewById(R.id.switch2);
        sw3 = findViewById(R.id.switch3);
        sw4 = findViewById(R.id.switch4);
        tv = findViewById(R.id.tview);
    }

    public void calcular(View v){
        int valor1 = Integer.parseInt(et1.getText().toString());
        int valor2 = Integer.parseInt(et2.getText().toString());
        int suma = valor1 + valor2;
        int resta = valor1 - valor2;
        int multiplicacion = valor1*valor2;
        int division = valor1/valor2;

        String resultado = "";
        if(sw1.isChecked() == true){
            resultado = resultado + "La suma es: "+suma+" / ";
        }
        if(sw2.isChecked() ==  true){
            resultado = resultado + "La resta es: "+resta+" / ";
        }
        if(sw3.isChecked() ==  true){
            resultado = resultado + "La resta es: "+multiplicacion+" / ";
        }
        if(sw4.isChecked() ==  true){
            resultado = resultado + "La resta es: "+division+" / ";
        }
        tv.setText("El resultado es: "+resultado);
    }
}