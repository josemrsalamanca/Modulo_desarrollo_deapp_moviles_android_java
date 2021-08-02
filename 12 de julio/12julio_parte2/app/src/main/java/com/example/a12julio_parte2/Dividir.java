package com.example.a12julio_parte2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Dividir extends AppCompatActivity {
    private TextView tv;
    private EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dividir);

        tv= findViewById(R.id.tv);
        String calcular = getIntent().getStringExtra("calcular");
        tv.setText(""+calcular);

        ed1= findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
    }

    public void dividir(View v){
        Intent dividir = new Intent(this, MainActivity.class);
        startActivity(dividir);
    }
}