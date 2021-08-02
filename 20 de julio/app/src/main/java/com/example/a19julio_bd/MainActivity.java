package com.example.a19julio_bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edcodigo, ednombre, edprecio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edcodigo = findViewById(R.id.codigo);
        ednombre = findViewById(R.id.nombre);
        edprecio = findViewById(R.id.precio);
    }

    public void crearProducto(View v){
        Intent i = new Intent(this,MainActivity2.class);
        i.putExtra("cod",edcodigo.getText().toString());
        i.putExtra("nom",ednombre.getText().toString());
        i.putExtra("pre",edprecio.getText().toString());
        startActivity(i);

        Admindb admin = new Admindb(this, "Productos",null,1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();
        String nombre = ednombre.getText().toString();
        String precio = edprecio.getText().toString();

        if (!codigo.isEmpty() && !nombre.isEmpty() && !precio.isEmpty()){
            ContentValues crear = new ContentValues();

            crear.put("codigo",codigo);
            crear.put("nombre",nombre);
            crear.put("precio",precio);

            base.insert("producto",null,crear);
            base.close();
            edcodigo.setText("");
            ednombre.setText("");
            edprecio.setText("");
            Toast.makeText(this,"Registro creado",Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "Debe completar todos los campos",Toast.LENGTH_LONG).show();
        }
    }

    public void buscarProductos(View v){
        Admindb admin = new Admindb(this,"Productos",null,1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila = base.rawQuery("select nombre, precio from producto where codigo = " + codigo,null);

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
        Admindb admin = new Admindb(this, "Productos",null,1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();
        String nombre = ednombre.getText().toString();
        String precio = edprecio.getText().toString();

        if (!codigo.isEmpty() && !nombre.isEmpty() && !precio.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("codigo",codigo);
            registro.put("nombre",nombre);
            registro.put("precio",precio);

            base.update("producto",registro,"codigo="+codigo,null);
            base.close();
            edcodigo.setText("");
            ednombre.setText("");
            edprecio.setText("");
            Toast.makeText(this,"Registro creado",Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "Debe completar todos los campos",Toast.LENGTH_LONG).show();
        }
    }

    public void eliminarProducto(View v){
        Admindb admin = new Admindb(this, "Productos",null,1);
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