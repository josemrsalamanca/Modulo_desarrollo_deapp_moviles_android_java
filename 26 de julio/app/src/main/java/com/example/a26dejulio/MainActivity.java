package com.example.a26dejulio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    private EditText aedt1,aedt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aedt1 = findViewById(R.id.edt1);
        aedt2 = findViewById(R.id.edt2);
    }
    public void mostrarCalendario(View v){
        DatePickerDialog d = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                aedt1.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        },2021,0,1);
        d.show();
    }
    public void mostrarHora(View v){
        TimePickerDialog d=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                aedt2.setText(hourOfDay+":"+minute);
            }
        },10,30,true);
        d.show();
    }
}
