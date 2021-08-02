package com.example.bd_14julio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edcodigo, ednombre, edprecio;

    /* se crea spinner 21 de julio*/
    private Spinner spproducto;

    ArrayList<String> listaProductos;
    ArrayList<Producto> productosLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edcodigo = findViewById(R.id.codigo);
        ednombre = findViewById(R.id.nombre);
        edprecio = findViewById(R.id.precio);

        /* derivado de la linea 21 */
        spproducto = findViewById(R.id.spinner);

        consultarListaProductos();

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,listaProductos);
        spproducto.setAdapter(adaptador);

    }

    public void consultarListaProductos(){
        Admindb admin= new Admindb(this,"Productos",null,1);
        SQLiteDatabase base= admin.getWritableDatabase();

        Producto p1 = null;
        productosLista = new ArrayList<Producto>();

        Cursor fila = base.rawQuery("select * from producto",null);

        while(fila.moveToNext()){
            p1= new Producto();
            p1.setCodigo(fila.getInt(0));
            p1.setNombre(fila.getString(1));
            p1.setPrecio(fila.getInt(2));
            productosLista.add(p1);
        }
        consultaProducto();
    }


    public void consultaProducto(){
        listaProductos = new ArrayList<String>();
        for(int i=0; i < productosLista.size();i++){

            listaProductos.add(productosLista.get(i).getCodigo()+" - " + productosLista.get(i).getNombre()+" "+
                    productosLista.get(i).getPrecio());
        }
    }


    public void crearProducto(View v) {
        Admindb admin = new Admindb(this, "Productos", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();
        /* la linea anterior abre el codigo para que este disponible para lectura y escritura */

        String codigo = edcodigo.getText().toString();
        String nombre = ednombre.getText().toString();
        String precio = edprecio.getText().toString();

        if (!codigo.isEmpty() && !nombre.isEmpty() && !precio.isEmpty()) {
            ContentValues crear = new ContentValues();
            /* va a guardar los diferentes valores la linea anterior en crear, por eso en las 3 lineas posteriores crear.put...*/

            crear.put("codigo", codigo);
            crear.put("nombre", nombre);
            crear.put("precio", precio);

            /*Asignamos en variable slo que ingresa el usuario*/

            base.insert("producto", null, crear);
            base.close();
            edcodigo.setText("");
            ednombre.setText("");
            edprecio.setText("");
            Toast.makeText(this, "Registro creado", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Debe completar todos los campos", Toast.LENGTH_LONG).show();
        }

    }


    public void buscarProducto(View v){
        Admindb admin = new Admindb(this,"Productos",null,1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila = base.rawQuery("select nombre,precio from producto where codigo = "+codigo,null);
            if(fila.moveToFirst()){
                ednombre.setText(fila.getString(0));
                edprecio.setText(fila.getString(1));
                base.close();
            }else{
                Toast.makeText(this,"El producto no existe",Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this,"Debe ingresar un codigo de producto",Toast.LENGTH_LONG).show();
        }
    }


    public void modificarProducto(View v){
        Admindb admin = new Admindb(this,"Productos",null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();
        String nombre = ednombre.getText().toString();
        String precio = edprecio.getText().toString();

        if(!codigo.isEmpty() && !nombre.isEmpty() && !precio.isEmpty()){
            ContentValues registro= new ContentValues();

            registro.put("codigo",codigo);
            registro.put("nombre",nombre);
            registro.put("precio", precio);

            base.update("producto",registro,"codigo="+codigo,null);
            base.close();
            edcodigo.setText("");
            ednombre.setText("");
            edprecio.setText("");
            Toast.makeText(this,"Registro modificado", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this,"Debes completar los campos",Toast.LENGTH_LONG).show();
        }
    }


    public void eliminarProducto(View v){
        Admindb admin = new Admindb(this,"Productos",null,1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        if(!codigo.isEmpty()){
            base.delete("producto","codigo="+codigo,null);
            base.close();
            edcodigo.setText("");
            ednombre.setText("");
            edprecio.setText("");
            Toast.makeText(this,"El registro fue eliminado", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "Ingresar un codigo",Toast.LENGTH_LONG).show();
        }
    }

}