package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.lecole_des_loustics.db.User;

public class MainMenu extends AppCompatActivity {

    private String firstName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // Récupération du texte + nom pour l'en-tête
        TextView header = findViewById(R.id.main_menu_header);
        firstName = ((MyApplication) this.getApplication()).getFirstName();

        String headerText = getResources().getString(R.string.main_menu_hello) + " " + firstName;
        header.setText(headerText);
    }

    public void subjectChoice(View view) {
        Intent intent = new Intent(this, SubjectList.class);
        startActivity(intent);
    }

    public void trophies(View view) {
        Intent intent = new Intent(this, Achievements.class);
        startActivity(intent);
    }

    public void logOut(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags((Intent.FLAG_ACTIVITY_CLEAR_TOP));
        startActivity(intent);
        finish();
    }
}