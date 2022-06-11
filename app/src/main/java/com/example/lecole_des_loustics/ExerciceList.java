package com.example.lecole_des_loustics;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class ExerciceList extends AppCompatActivity {

    public static final String SUBJECT = "subject";
    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_list);

        String subject = getIntent().getStringExtra(SUBJECT);

        linear = findViewById(R.id.exercice_list_inflate);

        miseAJourUI();
    }

    private void miseAJourUI() {
        LayoutInflater inflate = LayoutInflater.from(this);
        
    }
}