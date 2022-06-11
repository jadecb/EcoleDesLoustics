package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubjectList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);
    }

    public void maths(View view) {
        Intent intent = new Intent(this, ExerciceList.class);
        intent.putExtra(ExerciceList.SUBJECT, "maths");
        startActivity(intent);
    }

    public void french(View view) {
        Intent intent = new Intent(this, ExerciceList.class);
        intent.putExtra(ExerciceList.SUBJECT, "french");
        startActivity(intent);
    }

    public void history(View view) {
        Intent intent = new Intent(this, ExerciceList.class);
        intent.putExtra(ExerciceList.SUBJECT, "history");
        startActivity(intent);
    }

    public void geography(View view) {
        Intent intent = new Intent(this, ExerciceList.class);
        intent.putExtra(ExerciceList.SUBJECT, "geography");
        startActivity(intent);
    }
}