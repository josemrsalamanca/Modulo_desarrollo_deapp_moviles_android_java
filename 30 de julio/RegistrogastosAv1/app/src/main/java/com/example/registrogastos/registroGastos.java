package com.example.registrogastos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class registroGastos extends AppCompatActivity {


    private Spinner servicios;
    private EditText fecha;
    private EditText monto;
    ArrayList<String> listaServicios;
    ArrayList<Servicios> allservices;
    int servicioSelect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_gastos);

        servicios = findViewById(R.id.spServicios);
        fecha = findViewById(R.id.etFecha);
        monto = findViewById(R.id.etMonto);

        consultarServicios();
        ArrayAdapter<String> adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_item,listaServicios);
        servicios.setAdapter(adaptador);

        servicios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 0){
                    servicioSelect = allservices.get(position-1).getId();
                }else{
                    servicioSelect = 0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void consultarServicios() {
        Admindb conex = new Admindb(this, "Gastos", null, 1);
        SQLiteDatabase bd = conex.getReadableDatabase();

        Servicios servicio = null;
        allservices = new ArrayList<Servicios>();

        Cursor cursor = bd.rawQuery("SELECT rowid, nombre FROM servicios", null);

        while(cursor.moveToNext()){
            servicio = new Servicios();
            servicio.setId(cursor.getInt(0));
            servicio.setNombre(cursor.getString(1));

            allservices.add(servicio);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaServicios = new ArrayList<String>();
        listaServicios.add("Seleccione...");

        for(int i = 0; i < allservices.size(); i++){
            listaServicios.add(allservices.get(i).getId() + " - " + allservices.get(i).getNombre());
        }
    }


    public void crearGasto(View v){
        Admindb admin = new Admindb(this,"Gastos",null,1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String fechaGasto = fecha.getText().toString();
        int montoGasto = Integer.parseInt(monto.getText().toString());

        if(servicioSelect != 0 && !fechaGasto.isEmpty() && montoGasto > 0){
            ContentValues crear = new ContentValues();
            crear.put("servicio",servicioSelect);
            crear.put("fecha",fechaGasto);
            crear.put("monto",montoGasto);

            base.insert("registro_gastos",null,crear);
            base.close();
            fecha.setText("");
            monto.setText("");
            servicios.setSelection(0);

            Toast.makeText(this,"Gasto ingresado correctamente",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Debe ingresar todos los campos!",Toast.LENGTH_LONG).show();
        }
    }

    public void volver(View v){
        Intent volver = new Intent(this,MainActivity.class);
        startActivity(volver);
    }

    public void fecha(View v){
        Calendar now = Calendar.getInstance();
        int ano = now.get(Calendar.YEAR);
        int mes = now.get(Calendar.MONTH);
        int dia = now.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                fecha.setText(dia + " - " + (mes+1) + " - " + ano);
            }
        },ano,mes,dia);
        dialog.show();
    }

    public void nuevoServicio(View v){
        Intent nvoServicio = new Intent(this, NvoServicio.class);
        startActivity(nvoServicio);
    }
}