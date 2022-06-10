package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        String username = "cher invité";
        Intent intent = new Intent(this, MainMenu.class);
        intent.putExtra(MainMenu.USERNAME, username);
        startActivity(intent);
        finish();
    }

    public void userList(View view){
        Intent intent = new Intent(this, UserList.class);
        startActivity(intent);
    }
}