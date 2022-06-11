package com.example.lecole_des_loustics.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Exercice implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int exerciceId;

    @ColumnInfo(name = "subject")
    private String subject;

    @ColumnInfo(name = "exerciceName")
    private String exerciceName;

    @ColumnInfo(name = "type")
    private String type;


    /* Getters and Setters */

    public int getExerciceId() { return exerciceId; }

    public String getSubject() { return subject; }

    public String getExerciceName() { return exerciceName; }

    public String getType() { return type; }

    public void setExerciceId(int exerciceID) { this.exerciceId = exerciceID; }

    public void setSubject(String subject) { this.subject= subject; }

    public void setExerciceName(String exerciceName) { exerciceName = exerciceName; }

    public void setType(String type) { this.type = type; }
}
