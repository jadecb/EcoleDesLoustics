package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.example.lecole_des_loustics.db.DatabaseClient;
import com.example.lecole_des_loustics.db.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseClient db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = DatabaseClient.getInstance(getApplicationContext());
    }

    public void signIn(View view) {
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
    }

    public void signUp(View view) {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    public void guestLogIn(View view) {
        ((MyApplication) this.getApplication()).setFirstName("Invité");
        ((MyApplication) this.getApplication()).setLastName("");

        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
        finish();
    }

    public void userList(View view){
        Intent intent = new Intent(this, UserList.class);
        startActivity(intent);
    }
}