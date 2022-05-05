package com.example.persistence;

public class DatabaseTables {

    static class COUNTRY {
        static final String TABLE_NAME = "country";
        static final String COLUMN_NAME_ID = "id";
        static final String COLUMN_NAME_NAME = "name";
        static final String COLUMN_NAME_CAPITAL = "capital";
        static final String COLUMN_NAME_POPULATION = "population";
    }

    static final String SQL_CREATE_TABLE_COUNTRY =
            "CREATE TABLE " + COUNTRY.TABLE_NAME + " (" +
                    COUNTRY.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    COUNTRY.COLUMN_NAME_NAME + " TEXT," +
                    COUNTRY.COLUMN_NAME_CAPITAL + " TEXT," +
                    COUNTRY.COLUMN_NAME_POPULATION + " INT)";

    static final String SQL_DELETE_TABLE_COUNTRY =
            "DROP TABLE IF EXISTS " + COUNTRY.TABLE_NAME;
}
