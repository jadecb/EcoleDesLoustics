package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lecole_des_loustics.db.DatabaseClient;
import com.example.lecole_des_loustics.db.Exercice;
import com.example.lecole_des_loustics.db.QFillIn;

import org.w3c.dom.Text;

import java.util.List;

public class EFillIn extends AppCompatActivity {

    public static final String NAME = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_efill_in);
    }
}