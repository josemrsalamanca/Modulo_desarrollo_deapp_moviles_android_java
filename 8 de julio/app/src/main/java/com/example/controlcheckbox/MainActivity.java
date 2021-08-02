package com.example.controlcheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ed1, ed2;
    private CheckBox cb1, cb2,cb3,cb4;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.txt_valor1);
        ed2 = findViewById(R.id.txt_valor2);
        cb1 = findViewById(R.id.check_suma);
        cb2 = findViewById(R.id.check_resta);
        cb3 = findViewById(R.id.check_multiplicacion);
        cb4 = findViewById(R.id.check_division);
        tv = findViewById(R.id.tv_resultado);
    }
    public void calcular(View v){
        int valor1 = Integer.parseInt(ed1.getText().toString());
        int valor2 = Integer.parseInt(ed2.getText().toString());
        int suma = valor1 + valor2;
        int resta = valor1 - valor2;
        int multiplicacion = valor1 * valor2;
        int division = valor1/valor2;


        String resultado = "";
        if(cb1.isChecked() == true){
            resultado = resultado + "La suma es: " + suma + " / ";
        }
        if(cb2.isChecked() == true){
            resultado = resultado + "La resta es: " + resta + " / ";
        }
        if(cb3.isChecked() == true){
            resultado = resultado + "La multiplicacion es: " + multiplicacion + " / ";
        }
        if(cb4.isChecked() == true){
            resultado = resultado + "La division es: " + division + " / ";
        }
        tv.setText("El resultado es: "+resultado);
    }
}