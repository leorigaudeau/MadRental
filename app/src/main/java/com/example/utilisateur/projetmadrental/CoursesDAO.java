package com.example.utilisateur.projetmadrental;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

public class CoursesDAO
{
    public static List<CourseDTO> getListeCourses(Context context)
    {
// récupération de la base de données :
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
// requète :

        List<CourseDTO> listDTO=null;
        return listDTO;

    }
}
