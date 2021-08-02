package com.example.a1agosto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView atv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        atv5 = findViewById(R.id.tv5);

        String mes = getIntent().getStringExtra("mes");
        int luz = getIntent().getIntExtra("luz",0);
        int agua = getIntent().getIntExtra("agua",0);
        int suma = agua + luz;

        atv5.setText("Gasto Mensual: "+System.getProperty("line.separator")
        +System.getProperty("line.separator")+suma);
    }

    public void volver(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);

    }
}