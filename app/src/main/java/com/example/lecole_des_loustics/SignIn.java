package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lecole_des_loustics.db.DatabaseClient;
import com.example.lecole_des_loustics.db.User;

import java.nio.channels.AsynchronousChannelGroup;

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

        EditText editTextFirstName = findViewById(R.id.sign_in_fist_name);
        final String firstName = editTextFirstName.getText().toString().trim();
        EditText editTextLastName = findViewById(R.id.sign_in_last_name);
        final String lastName = editTextLastName.getText().toString().trim();

        //Vérifie que tous les champs sont remplis puis set le currentUser
        if (firstName.isEmpty()) {
            editTextFirstName.setError("Tu dois entrer ton prénom");
            editTextFirstName.requestFocus();
            return;
        }

        if (lastName.isEmpty()) {
            editTextLastName.setError("Tu dois entrer ton nom");
            editTextLastName.requestFocus();
            return;
        }

        // Set le currentUser et le redirige vers le menu principal
        if (firstName.isEmpty()==false && lastName.isEmpty()==false) {
            User loggedUser = db.getAppDatabase()
                    .userDao()
                    .getUserByName(firstName, lastName);

            if (loggedUser != null) {
                ((MyApplication) this.getApplication()).setFirstName(firstName);
                ((MyApplication) this.getApplication()).setLastName(lastName);

                Intent intent = new Intent(this, MainMenu.class);
                startActivity(intent);
                finish();
            } else {
                editTextFirstName.setText("");
                editTextLastName.setText("");

                Toast.makeText(getApplicationContext(), "Identifiants invalides", Toast.LENGTH_LONG);
            }
        }


    }
}