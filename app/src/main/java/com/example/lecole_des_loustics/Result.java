package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Result extends AppCompatActivity {

    public static final String NAME = "name";
    public static final String POINTS = "points";
    public static final String QUESTIONS = "questions";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }
}