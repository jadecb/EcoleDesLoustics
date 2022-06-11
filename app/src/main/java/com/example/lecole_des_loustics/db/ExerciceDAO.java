package com.example.lecole_des_loustics.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExerciceDAO {

    @Query("SELECT * FROM exercice ORDER BY subject")
    List<Exercice> getAll();

    @Query("SELECT * FROM exercice WHERE subject LIKE :subject")
    List<Exercice> getExercicesBySubject(String subject);

    @Insert
    void insert(Exercice exercice);

    @Delete
    void delete(Exercice exercice);

    @Update
    void update(User user);
}
