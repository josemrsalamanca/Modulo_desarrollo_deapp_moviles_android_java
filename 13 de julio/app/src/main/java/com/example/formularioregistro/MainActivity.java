package com.example.formularioregistro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView atv1;
    private EditText aedt1, aedt2, aedt3, aedt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        atv1 = findViewById(R.id.tv1);
        aedt1 = findViewById(R.id.edt1);
        aedt2 = findViewById(R.id.edt2);
        aedt3 = findViewById(R.id.edt3);
        aedt4 = findViewById(R.id.edt4);
    }

    public void registrar(View v){
        Intent i = new Intent(this,MainActivity2.class);
        i.putExtra("dato1",aedt1.getText().toString());
        i.putExtra("dato2",aedt2.getText().toString());
        i.putExtra("dato3",aedt3.getText().toString());
        i.putExtra("dato4",aedt4.getText().toString());
        startActivity(i);
    }
}

