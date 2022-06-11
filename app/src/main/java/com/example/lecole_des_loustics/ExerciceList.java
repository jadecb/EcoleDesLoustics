package com.example.lecole_des_loustics;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.lecole_des_loustics.db.DatabaseClient;
import com.example.lecole_des_loustics.db.Exercice;

import java.util.ArrayList;
import java.util.List;

public class ExerciceList extends AppCompatActivity {

    public static final String SUBJECT = "subject";

    private DatabaseClient db;
    private ExerciceAdapter adapter;

    private ListView exerciceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_list);

        // Récupération du DatabaseClient
        db = DatabaseClient.getInstance((getApplicationContext()));

        // Récupérer les vues
        exerciceList = findViewById(R.id.exerciceListView);

        // Lier l'adapter au listView
        adapter = new ExerciceAdapter(this, new ArrayList<Exercice>());
        exerciceList.setAdapter(adapter);
    }

    private void getExercices(String subject) {
        //Classe asynchrone ; récupère les utilisateurs, met à jour le ListView et l'activité
        class GetExercice extends AsyncTask<Void, Void, List<Exercice>> {

            @Override
            protected List<Exercice> doInBackground(Void... voids) {
                List<Exercice> exerciceList = db.getAppDatabase()
                        .exerciceDAO()
                        .getExercicesBySubject(subject);
                return exerciceList;
            }

            @Override
            protected void onPostExecute(List<Exercice> exercices) {
                super.onPostExecute(exercices);

                adapter.clear();
                adapter.addAll(exercices);

                adapter.notifyDataSetChanged();
            }
        }

        GetExercice ge = new GetExercice();
        ge.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();

        String subject = getIntent().getStringExtra(SUBJECT);
        getExercices(subject);
    }
}