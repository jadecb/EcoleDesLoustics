package com.example.lecole_des_loustics.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity
public class QFillIn implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int qFillInID;

    @ColumnInfo(name = "exercice")
    private int exercice;

    @ColumnInfo(name = "numQuestion")
    private int numQuestion;

    @ColumnInfo(name = "statement")
    private String statement;

    @ColumnInfo(name = "answer")
    private String answer;


    /* Getters and setters */

    public int getQFillInID() { return qFillInID; }

    public int getExercice() { return exercice; }

    public int getNumQuestion() { return numQuestion; }

    public String getStatement() { return statement; }

    public String getAnswer() { return answer; }

    public void setQFillInID(int q_FillInID) { this.qFillInID = q_FillInID; }

    public void setExercice(int exercice) { this.exercice = exercice; }

    public void setNumQuestion(int numQuestion) { this.numQuestion = numQuestion; }

    public void setStatement(String statement) { this.statement = statement; }

    public void setAnswer(String answer) { this.answer = answer; }
}
