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
            database.execSQL("CREATE TABLE IF NOT EXISTS persons(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, age INT(3))");

            //Deletar tabela
            //database.execSQL("DROP TABLE persons");

            // inserir dados na tabela
//            database.execSQL("INSERT INTO persons(name, age) VALUES('João', 31)");
//            database.execSQL("INSERT INTO persons(name, age) VALUES('Maria', 32)");
//            database.execSQL("INSERT INTO persons(name, age) VALUES('Lea', 18)");
//            database.execSQL("INSERT INTO persons(name, age) VALUES('José', 50)");
//            database.execSQL("INSERT INTO persons(name, age) VALUES('Mario', 40)");

            // Atualiza registros
            //database.execSQL("UPDATE persons SET age = 19 WHERE name = 'Lea'");
            //database.execSQL("UPDATE persons SET age = 19, name = 'Lea Dominguez' WHERE id = 3");

            // Deletando um registro da tabela
            //database.execSQL("DELETE FROM persons WHERE id = 10");
            // Apagar todos os registros da tabela
            database.execSQL("DELETE FROM persons");

            // Recuperar dados
//            String query =
//                    "SELECT name, age FROM persons " +
//                            "WHERE name = 'João'";

//            String query =
//                    "SELECT name, age FROM persons " +
//                            "WHERE age >= 35 OR age = 18";

//            String query =
//                    "SELECT name, age FROM persons " +
//                            "WHERE age IN(18,35) ";

//            String query =
//                    "SELECT name, age FROM persons " +
//                            "WHERE age BETWEEN 30 AND 35";

//            String query =
//                    "SELECT name, age FROM persons " +
//                            "WHERE name LIKE 'José'";

            // ASC ascendente ou DESC descendente
            // LIMIT 3
//            String query =
//                    "SELECT name, age FROM persons " +
//                            "WHERE 1=1 ORDER BY age";

            String query =
                    "SELECT * FROM persons " +
                            "WHERE 1=1";

            Cursor cursor = database.rawQuery(query, null);

            // Indices da tabela
            int indexID = cursor.getColumnIndex("id");
            int indexName = cursor.getColumnIndex("name");
            int indexAge = cursor.getColumnIndex("age");

            cursor.moveToFirst();
            while (cursor != null) {
                String id = cursor.getString(indexID);
                String name = cursor.getString(indexName);
                String age = cursor.getString(indexAge);

                Log.i("Result - name ", name + " " + "Age: " + age + " " + "ID: " + id);
                cursor.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}