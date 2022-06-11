package com.example.lecole_des_loustics.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class QPick implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int qPickId;

    @ColumnInfo(name = "exercice")
    private int exercice;

    @ColumnInfo(name = "numQuestion")
    private int numquestion;

    @ColumnInfo(name = "statement")
    private String statement;

    @ColumnInfo(name = "rightAnswer")
    private String rightAnswer;

    @ColumnInfo(name = "wrongAnswer1")
    private String wrongAnswer1;

    @ColumnInfo(name = "wrongAnswer2")
    private String wrongAnswer2;


    /* Getters and Setters */

    public int getQPickId() { return qPickId; }

    public int getExercice() { return exercice; }

    public int getNumquestion() { return numquestion; }

    public String getStatement() { return statement; }

    public String getRightAnswer() { return rightAnswer; }

    public String getWrongAnswer1() { return wrongAnswer1; }

    public String getWrongAnswer2() { return wrongAnswer2; }

    public void setQPickId(int qPickId) { this.qPickId = qPickId; }

    public void setExercice(int exercice) { this.exercice = exercice; }

    public void setNumquestion(int numquestion) { this.numquestion = numquestion; }

    public void setStatement(String statement) { this.statement = statement; }

    public void setRightAnswer(String rightAnswer) { this.rightAnswer = rightAnswer; }

    public void setWrongAnswer1(String wrongAnswer1) { this.wrongAnswer1 = wrongAnswer1; }

    public void setWrongAnswer2(String wrongAnswer2) { this.wrongAnswer2 = wrongAnswer2; }
}
