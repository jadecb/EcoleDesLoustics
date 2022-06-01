package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    public static final String USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        String username = getIntent().getStringExtra(USERNAME);

        TextView header = findViewById(R.id.main_menu_header);
        header.setText("Bienvenue " + username);
    }

    public void subjectChoice(View view) {
        Intent intent = new Intent(this, SubjectList.class);
        startActivity(intent);
    }

    public void trophies(View view) {
        Intent intent = new Intent(this, Achievements.class);
        startActivity(intent);
    }

    public void options(View view) {
        Intent intent = new Intent(this, Options.class);
        startActivity(intent);
    }

    public void logOut(View view) {
    }
}