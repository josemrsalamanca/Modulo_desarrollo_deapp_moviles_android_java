package com.example.a19julio_bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Eliminar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
    }

    public void volver(View v){
        Intent volver = new Intent(this,MainActivity.class);
        startActivity(volver);
    }
}