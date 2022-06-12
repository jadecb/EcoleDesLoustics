package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lecole_des_loustics.db.DatabaseClient;
import com.example.lecole_des_loustics.db.QPick;

import org.w3c.dom.Text;

public class EPick extends AppCompatActivity {

    private DatabaseClient db;

    public static final String NAME = "";
    public static final String ID = "6";
    public static final String QUESTION = "1";
    public static final String POINTS = "0";

    private TextView name;
    private TextView statement;
    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epick);

        name = findViewById(R.id.fillInExerciceName);
        statement = findViewById(R.id.fillIntStatement);
        button1 = findViewById(R.id.fillInButton1);
        button2 = findViewById(R.id.fillInButton2);
        button3 = findViewById(R.id.fillInButton3);

        String exerciceName = getIntent().getStringExtra(NAME);
        name.setText(exerciceName);

        db = DatabaseClient.getInstance(getApplicationContext());
    }

    private void getQuestion(int id, int num_question, TextView statement, Button button1, Button button2, Button button3) {
        class GetQuestion extends AsyncTask<Void, Void, QPick> {
            @Override
            protected QPick doInBackground(Void... voids) {
                QPick question = db.getAppDatabase()
                        .qPickDAO()
                        .getquestion(id, num_question);
                return question;
            }

            @Override
            protected void onPostExecute(QPick question) {
                statement.setText(question.getStatement());
                button1.setText(question.getRightAnswer());
                button2.setText(question.getWrongAnswer1());
                button3.setText(question.getWrongAnswer2());
            }
        }

        GetQuestion gq = new GetQuestion();
        gq.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();

        int id = getIntent().getIntExtra(String.valueOf(ID), 0);
        int numQuestion = getIntent().getIntExtra(String.valueOf(QUESTION), 1);

        getQuestion(id, numQuestion, statement, button1, button2, button3);
    }

    public void rightAnswer(View view) {
    }

    public void wrongAnswer(View view) {
    }

}