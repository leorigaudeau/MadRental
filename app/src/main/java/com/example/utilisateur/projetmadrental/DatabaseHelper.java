package com.example.utilisateur.projetmadrental;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    // Constructeur :
    public DatabaseHelper(Context context)
    {
        super(context, "courses.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //db.execSQL("CREATE TABLE TABLE_COURSES");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS vehicule ");
        onCreate(db);
    }
}