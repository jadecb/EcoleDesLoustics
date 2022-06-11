package com.example.lecole_des_loustics.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class DatabaseClient {

    // Instance unique permettant de faire le lien avec la base de données
    private static DatabaseClient instance;

    // Objet représentant la base de données de votre application
    private AppDatabase appDatabase;

    // Constructeur
    private DatabaseClient(final Context context) {

        // Créer l'objet représentant la base de données de votre application
        // à l'aide du "Room database builder"
        // EcoleDesLoustics est le nom de la base de données
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "EcoleDesLoustics").addCallback(roomDatabaseCallback).build();

        ////////// REMPLIR LA BD à la première création à l'aide de l'objet roomDatabaseCallback
        // Ajout de la méthode addCallback permettant de populate (remplir) la base de données à sa création
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "EcoleDesLoustics").addCallback(roomDatabaseCallback).build();
    }

    // Méthode statique
    // Retourne l'instance de l'objet DatabaseClient
    public static synchronized DatabaseClient getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseClient(context);
        }
        return instance;
    }

    // Retourne l'objet représentant la base de données de  l'application
    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

    // Objet permettant de populate (remplir) la base de données à sa création
    RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {

        // Called when the database is created for the first time.
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            db.execSQL("INSERT INTO user (firstName, lastName) VALUES(\"Invité\", \"\");");
            db.execSQL("INSERT INTO user (firstName, lastName) VALUES(\"Clémence\", \"Linard\");");

            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"maths\", \"addition\", \"arithmetics\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"maths\", \"substraction\", \"arithmetics\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"maths\", \"multiplication\", \"arithmetics\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"maths\", \"division\", \"arithmetics\")");

            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"french\", \"conjugaison\", \"fillIn\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"french\", \"orthgraph\", \"pick\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"french\", \"grammar\", \"pick\")");

            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"history\", \"antiquity\", \"pick\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"history\", \"middle-ages\", \"pick\")");

            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"geography\", \"regions\", \"pick\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"geography\", \"countries\", \"fillIn\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"geography\", \"capitals\", \"pick\")");

            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(5, \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(5, \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(5, \"\", \"\", \"\")");

            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(6, \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(6, \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(6, \"\", \"\", \"\")");

            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(7, \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(7, \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(7, \"\", \"\", \"\")");

            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(8, \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(8, \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(8, \"\", \"\", \"\")");

            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(9, \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(9, \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(9, \"\", \"\", \"\")");

            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(10, \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(10, \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(10, \"\", \"\", \"\")");

            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(11, \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(11, \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(11, \"\", \"\", \"\")");

            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(12, \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(12, \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(12, \"\", \"\", \"\")");
        }
    };
}

