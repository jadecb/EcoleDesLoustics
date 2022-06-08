package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.lecole_des_loustics.db.DatabaseClient;

public class SignIn extends AppCompatActivity {

    // DATA
    private DatabaseClient db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // Récupération du DatabaseClient
        db = DatabaseClient.getInstance(getApplicationContext());
    }

    public void signIn(View view) {
    }
}