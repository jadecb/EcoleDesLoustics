package com.example.lecole_des_loustics.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface QPickDAO {

    @Query("SELECT * FROM qpick WHERE exercice LIKE :exercice AND " + "numQuestion LIKE :question")
    QPick getquestion(int exercice, int question);

    @Insert
    void insert(QPick qPick);

    @Delete
    void delete(QPick qPick);

    @Update
    void update(QPick qPick);
}
