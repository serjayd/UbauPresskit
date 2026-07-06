package com.sympstudio.ubaupresskit;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ubauDB";
    private static final int DATABASE_VERSION = 2;


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE Subscribers (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT, " +
                        "email TEXT, " +
                        "early_game_access INTEGER, " +
                        "concept_art_pack INTEGER, " +
                        "exclusive_wallpapers INTEGER)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Subscribers");
        onCreate(db);
    }

    public boolean insertSubscriber(String name, String email, boolean option1, boolean option3, boolean option4) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("early_game_access", option1);
        values.put("concept_art_pack", option3);
        values.put("exclusive_wallpapers", option4);


        long result = db.insert("Subscribers", null, values);

        db.close();

        return result != -1;
    }
}

