package com.example.formularioregistro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView atv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        atv2= findViewById(R.id.tv2);

        String dato1 = getIntent().getStringExtra("dato1");
        String dato2 = getIntent().getStringExtra("dato2");
        String dato3 = getIntent().getStringExtra("dato3");
        String dato4 = getIntent().getStringExtra("dato4");

        atv2.setText("Los datos ingresados son " +System.getProperty("line.separator")+
                System.getProperty("line.separator") +"Nombre: "+ dato1 + System.getProperty("line.separator")
                + "Apellidos: "+ dato2+System.getProperty("line.separator") +"Mail: "+
                dato3 +System.getProperty("line.separator") + "Celular: "+ dato4);
    }

    public void volver(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}