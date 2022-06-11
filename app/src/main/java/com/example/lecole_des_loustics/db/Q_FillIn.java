package com.example.lecole_des_loustics.db;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import java.io.Serializable;

public class Q_FillIn implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int q_FillInID;

    @ColumnInfo(name = "exercice")
    private int exercice;

    @ColumnInfo(name = "statement")
    private String statement;

    @ColumnInfo(name = "answer")
    private String answer;


    /* Getters and setters */

    public int getQ_FillInID() { return q_FillInID; }

    public int getExercice() { return exercice; }

    public String getStatement() { return statement; }

    public String getAnswer() { return answer; }

    public void setQ_FillInID(int q_FillInID) { this.q_FillInID = q_FillInID; }

    public void setExercice(int exercice) { this.exercice = exercice; }

    public void setStatement(String statement) { this.statement = statement; }

    public void setAnswer(String answer) { this.answer = answer; }
}
