package com.example.lecole_des_loustics.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface QFillInDAO {

    @Query("SELECT * FROM qfillin WHERE exercice LIKE :exercice AND " + "numQuestion LIKE :question")
    QFillIn getQuestion(int exercice, int question);

    @Insert
    void insert(QFillIn qFillIn);

    @Delete
    void delete(QFillIn qFillIn);

    @Update
    void update(QFillIn qFillIn);
}
