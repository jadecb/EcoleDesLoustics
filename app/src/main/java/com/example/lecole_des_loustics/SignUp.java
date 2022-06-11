package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lecole_des_loustics.db.DatabaseClient;
import com.example.lecole_des_loustics.db.User;

public class SignUp extends AppCompatActivity {

    private DatabaseClient db;

    private EditText editTextFirstName;
    private EditText editTextLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Récupération du DatabaseClient
        db = DatabaseClient.getInstance(getApplicationContext());

        // Récupérer les vues
        editTextFirstName = findViewById(R.id.sign_in_fist_name);
        editTextLastName = findViewById(R.id.sign_in_last_name);
    }

    public void signUp(View view) {
        // Récupérer les informations contenues dans les vues
        final String firstName = editTextFirstName.getText().toString().trim();
        final String lastName = editTextLastName.getText().toString().trim();

        // Vérifier les informations fournies par l'utilisateur
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

        // Création d'une classe asynchrone pour sauvegarder le nouveau profil
        class SaveUser extends AsyncTask<Void, Void, User> {
            @Override
            protected User doInBackground(Void... voids) {
                // Création d'un utilisateur
                User user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);

                // Ajout à la base de données
                db.getAppDatabase()
                        .userDao()
                        .insert(user);

                return user;
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);

                setResult(RESULT_OK);
                finish();
                Toast.makeText(getApplicationContext(), "Prodil créé !", Toast.LENGTH_LONG);
            }
        }

        // Exécution de la demande asynchrone
        SaveUser su = new SaveUser();
        su.execute();
    }
}