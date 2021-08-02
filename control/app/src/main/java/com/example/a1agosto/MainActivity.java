package com.example.a1agosto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView atv1, atv2, atv3, atv4, atv5;
    private EditText aedmes, aedluz, aedagua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        atv1 = findViewById(R.id.tv1);
        atv2 = findViewById(R.id.tv2);
        atv3 = findViewById(R.id.tv3);
        atv4 = findViewById(R.id.tv4);
        aedmes = findViewById(R.id.edmes);
        aedluz = findViewById(R.id.edluz);
        aedagua = findViewById(R.id.edagua);
    }

    public void ingresar(View v){
        AdminBD admin = new AdminBD(this,"gastos",null,1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String mes = aedmes.getText().toString();
        int luz = Integer.parseInt(aedluz.getText().toString());
        int agua = Integer.parseInt(aedagua.getText().toString());

        if(!mes.isEmpty() && luz>0 && agua>0) {
            ContentValues crear = new ContentValues();
            crear.put("mes", mes);
            crear.put("luz", luz);
            crear.put("agua", agua);

            base.insert("gasto", null, crear);
            base.close();

            aedmes.setText("");
            aedluz.setText("");
            aedagua.setText("");
            Toast.makeText(this,"Registro creado",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Debe llenar todos los campos",Toast.LENGTH_LONG).show();
        }

        Intent i = new Intent(this,MainActivity2.class);
        i.putExtra("mes",mes);
        i.putExtra("luz",luz);
        i.putExtra("agua",agua);
        startActivity(i);
    }
}