package com.example.a14julio_bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
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
        Admindb admin = new Admindb(this,"Productos", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();
        String nombre = ednombre.getText().toString();
        String precio = edprecio.getText().toString();

        if (!codigo.isEmpty() && !nombre.isEmpty() && !precio.isEmpty()){
            ContentValues crear = new ContentValues();

            crear.put("codigo", codigo);
            crear.put("nombre", nombre);
            crear.put("precio",precio);

            base.insert("producto",null,crear);
            base.close();

            edcodigo.setText("");
            ednombre.setText("");
            edprecio.setText("");

            Toast.makeText(this, "Registro creado", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Debe complementar todos los campos", Toast.LENGTH_SHORT).show();
        }

    }
}