package com.example.registrogastos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class Comparar extends AppCompatActivity {
    Spinner mes1, anno1, mes2,anno2;
    ListView lvmes1, lvmes2;
    ArrayList<detalleServicio> rgastosant = new ArrayList<detalleServicio>();
    ArrayList<String> listainfoant = new ArrayList<String>();
    ArrayList<detalleServicio> rgastosact = new ArrayList<detalleServicio>();
    ArrayList<String> listainfoact = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparar);
        mes1 = findViewById(R.id.mes1);
        anno1 =findViewById(R.id.anno1);
        mes2 = findViewById(R.id.mes2);
        anno2 = findViewById(R.id.anno2);
        ArrayAdapter<CharSequence> admes = ArrayAdapter.createFromResource(this,R.array.meses, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adanno = ArrayAdapter.createFromResource(this, R.array.annos, android.R.layout.simple_spinner_item);


        mes1.setAdapter(admes);
        mes2.setAdapter(admes);
        anno1.setAdapter(adanno);
        anno2.setAdapter(adanno);

        lvmes1 = findViewById(R.id.lvMes1);
        lvmes2 = findViewById(R.id.lvMes2);

        ArrayAdapter adap1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listainfoant);
        lvmes1.setAdapter(adap1);
        ArrayAdapter adap2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listainfoact);
        lvmes2.setAdapter(adap2);
    }

    public void compararGastos(View v){
        Admindb conex = new Admindb(this, "Gastos", null, 1);
        SQLiteDatabase bd = conex.getWritableDatabase();

        int mesini = devuelveMes(mes1.getSelectedItem().toString());
        int mesfin = devuelveMes(mes2.getSelectedItem().toString());
        int annoini = 0;
        int annofin = 0;
        if(anno1.getSelectedItem().toString() != "Seleccione..."){
            annoini = Integer.parseInt(anno1.getSelectedItem().toString());
        }
        if(anno2.getSelectedItem().toString() != "Seleccione..."){
            annofin = Integer.parseInt(anno2.getSelectedItem().toString());
        }

        if(mesini > 0 && mesfin > 0 && annoini > 0 && annofin > 0){
            detalleServicio serv1 = null;
            detalleServicio serv2 = null;

            String fechames1ini = annoini+"-"+mesini+"-01";
            String fechames1fin = annoini+"-"+mesini+"-31";

            String fechames2ini = annofin+"-"+mesfin+"-01";
            String fechames2fin = annofin+"-"+mesfin+"-31";

            Cursor dataini =bd.rawQuery("Select s.nombre, rg.fecha, rg.monto FROM registro_gastos rg INNER JOIN servicios s ON (s.rowid = rg.servicio) WHERE rg.fecha between '"+ fechames1ini +"' AND '" + fechames1fin+"'", null);
            while(dataini.moveToNext()){
                serv1.setServicio(dataini.getInt(0));
                serv1.setFecha(dataini.getString(1));
                serv1.setMonto(dataini.getInt(2));

                rgastosant.add(serv1);
            }

            Cursor datafin = bd.rawQuery("Select s.nombre, rg.fecha, rg.monto FROM registro_gastos rg INNER JOIN servicios s ON (s.rowid = rg.servicio) WHERE rg.fecha between '"+ fechames2ini +"' AND '" + fechames2fin+"'", null);
            while(datafin.moveToNext()){
                serv2.setServicio(datafin.getInt(0));
                serv2.setFecha(datafin.getString(1));
                serv2.setMonto(datafin.getInt(2));

                rgastosact.add(serv2);
            }
            obtenerListas();
        }
        else {
            Toast.makeText(this,"Debe seleccionar todos los campos", Toast.LENGTH_LONG).show();
        }

    }

    private void obtenerListas() {

        for(int i = 0; i < rgastosant.size(); i++){
            listainfoant.add(rgastosant.get(i).getServicio() + ": " + rgastosant.get(i).getMonto() + " (Fecha: " + rgastosant.get(i).getFecha() + ")");
        }

        for(int i = 0; i < rgastosact.size(); i++){
            listainfoact.add(rgastosact.get(i).getServicio() + ": " + rgastosact.get(i).getMonto() + " (Fecha: " + rgastosact.get(i).getFecha() + ")");
        }
    }

    private int devuelveMes(String mes){
        int mesNum = 0;
        switch(mes){
            case "Enero":
                mesNum = 1;
                break;
            case "Febrero":
                mesNum = 2;
                break;
            case "Marzo":
                mesNum = 3;
                break;
            case "Abril":
                mesNum = 4;
                break;
            case "Mayo":
                mesNum = 5;
                break;
            case "Junio":
                mesNum = 6;
                break;
            case "Julio":
                mesNum = 7;
                break;
            case "Agosto":
                mesNum = 8;
                break;
            case "Septiembre":
                mesNum = 9;
                break;
            case "Octubre":
                mesNum = 10;
                break;
            case "Noviembre":
                mesNum = 11;
                break;
            case "Diciembre":
                mesNum = 12;
                break;
            default:
                mesNum = 0;
                break;
        }
        return mesNum;
    }

    public void volver(View v){
        Intent welcomeBack = new Intent(this, MainActivity.class);
        startActivity(welcomeBack);
    }
}