package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ed1, ed2;
    private TextView tv1;
    private Spinner sp1;
    private String[] op = {"Sumar","Restar","Multiplicar","Dividir"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.edit1);
        ed2 = findViewById(R.id.edit2);
        tv1 = findViewById(R.id.textv1);
        sp1 = findViewById(R.id.spinner);

        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,op);
        sp1.setAdapter(adaptador);
    }
    public void operar(View v){
        int valor1 = Integer.parseInt(ed1.getText().toString());
        int valor2 = Integer.parseInt(ed2.getText().toString());

        String operacion= sp1.getSelectedItem().toString();

        if(operacion.equals("Sumar")){
            int suma = valor1 + valor2;
            tv1.setText("El resultado de la suma es: "+suma);
        }else if(operacion.equals("Restar")){
            int resta = valor1 - valor2;
            tv1.setText("El resultado de la resta es:"+resta);
        }else if(operacion.equals("Multiplicar")){
            int multiplicacion = valor1*valor2;
            tv1.setText("El resultado de la multiplcacion es:"+multiplicacion);
        }else{
            int division = valor1/valor2;
            tv1.setText("El resultado de la division es:"+division);
        }
    }
}