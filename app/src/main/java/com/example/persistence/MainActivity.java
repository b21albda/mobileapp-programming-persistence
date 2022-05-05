package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
        Cursor cursor = db.query(DatabaseTables.COUNTRY.TABLE_NAME, null, null,null,null,null,null);
        List<Country> countries = new ArrayList<>();
        while (cursor.moveToNext()) {
            Country country = new Country(
                    cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseTables.COUNTRY.COLUMN_NAME_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.COUNTRY.COLUMN_NAME_NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.COUNTRY.COLUMN_NAME_CAPITAL)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseTables.COUNTRY.COLUMN_NAME_POPULATION))
            );
            countries.add(country);
        }

        cursor.close();

        writeToActivity(countries);
    }

    private void writeToActivity(final List<Country> countries) {
        TextView tv_display = findViewById(R.id.tv_display);

        if (countries.isEmpty()) {
            tv_display.setText("No data in database");
            return;
        }

        String text = "";

        for (Country country : countries) {
            text += country.getName() + " " + country.getCapital() + " " + country.getPopulation() + "\n";
        }

        tv_display.setText(text);
    }
}
