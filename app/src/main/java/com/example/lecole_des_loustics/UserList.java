package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.lecole_des_loustics.db.DatabaseClient;
import com.example.lecole_des_loustics.db.User;

import java.util.ArrayList;
import java.util.List;

public class UserList extends AppCompatActivity {

    //Data
    private DatabaseClient db;
    private UsersAdapter adapter;

    //View
    private ListView userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        // Récupération du DatabaseClient
        db = DatabaseClient.getInstance(getApplicationContext());

        // Récupérer les vues
        userList = findViewById(R.id.userListView);

        // Lier l'adapter au listView
        adapter = new UsersAdapter(this, new ArrayList<User>());
        userList.setAdapter(adapter);
    }

    private void getUsers() {
        //Classe asynchrone ; récupère les utilisateurs, met à jour le ListView et l'activité
        class GetUsers extends AsyncTask<Void, Void, List<User>> {

            @Override
            protected List<User> doInBackground(Void... voids) {
                List<User> userList = db.getAppDatabase()
                        .userDao()
                        .getAll();
                return userList;
            }

            @Override
            protected void onPostExecute(List<User> user) {
                super.onPostExecute(user);

                // Mettre à jour l'adapter avec la liste de taches
                adapter.clear();
                adapter.addAll(user);

                // Now, notify the adapter of the change in source
                adapter.notifyDataSetChanged();

            }
        }

        // Exécution de la demande asynchrone
        GetUsers gu = new GetUsers();
        gu.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Mise à jour des utilisateurs
        getUsers();
    }
}
