package com.example.lecole_des_loustics.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Exercice.class, QFillIn.class, QPick.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDAO userDao();

    public abstract ExerciceDAO exerciceDAO();
    public abstract QFillInDAO qFillInDAO();
    public abstract QPickDAO qPickDAO();
}
