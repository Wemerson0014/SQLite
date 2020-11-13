package com.estudo.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // Cria banco de dados
            SQLiteDatabase database = openOrCreateDatabase("app", MODE_PRIVATE, null);
            // Cria tabela do BD
            database.execSQL("CREATE TABLE IF NOT EXISTS persons(name VARCHAR, age INT(3))");
            // inserir dados na tabela
            database.execSQL("INSERT INTO persons(name, age) VALUES('João', 31)");
            database.execSQL("INSERT INTO persons(name, age) VALUES('Maria', 32)");
            // Recuperar dados
            Cursor cursor = database.rawQuery("SELECT name, age FROM persons", null);
            // Indices da tabela
            int indexName = cursor.getColumnIndex("name");
            int indexAge = cursor.getColumnIndex("age");

            cursor.moveToFirst();
            while (cursor != null) {
                Log.i("Result - name: ", cursor.getString(indexName));
                Log.i("Result - age: ", cursor.getString(indexAge));
                cursor.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}