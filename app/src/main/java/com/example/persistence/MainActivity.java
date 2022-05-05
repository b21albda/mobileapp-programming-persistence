package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();

        Button btn_read = findViewById(R.id.btn_read);
        Button btn_write = findViewById(R.id.btn_write);

        btn_read.setOnClickListener(View -> { readFromDb(); });
        btn_write.setOnClickListener(View -> { writeToDb(); });
    }

    private void writeToDb() {
        EditText et_country = findViewById(R.id.et_country);
        EditText et_capital = findViewById(R.id.et_capital);
        EditText et_population = findViewById(R.id.et_population);

        ContentValues values = new ContentValues();
        values.put(DatabaseTables.COUNTRY.COLUMN_NAME_NAME, et_country.getText().toString());
        values.put(DatabaseTables.COUNTRY.COLUMN_NAME_CAPITAL, et_capital.getText().toString());
        values.put(DatabaseTables.COUNTRY.COLUMN_NAME_POPULATION, Integer.parseInt(et_population.getText().toString()));

        long newRowId = db.insert(DatabaseTables.COUNTRY.TABLE_NAME, null, values);
    }

    private void readFromDb() {
    }
}
