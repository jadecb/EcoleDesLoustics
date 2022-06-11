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


            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"maths\", \"Addition\", \"arithmetics\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"maths\", \"Soustraction\", \"arithmetics\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"maths\", \"Multiplication\", \"arithmetics\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"maths\", \"Division\", \"arithmetics\")");

            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"french\", \"Conjugaison\", \"fillIn\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"french\", \"Orthgraphe\", \"pick\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"french\", \"Grammaire\", \"pick\")");

            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"history\", \"Antiquité\", \"pick\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"history\", \"Moyen-Âge\", \"pick\")");

            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"geography\", \"Régions\", \"pick\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"geography\", \"Pays\", \"fillIn\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"geography\", \"Capitales\", \"pick\")");


            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(5, 1, \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(5, 2, \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(5, 3, \"\", \"\")");

            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(11, 1, \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(11, 2, \"\", \"\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(11, 3, \"\", \"\")");

            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (6, 1, \"\", \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (6, 2, \"\", \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (6, 3, \"\", \"\", \"\", \"\")");

            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (7, 1, \"\", \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (7, 2, \"\", \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (7, 3, \"\", \"\", \"\", \"\")");

            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (8, 1, \"\", \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (8, 2, \"\", \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (8, 3, \"\", \"\", \"\", \"\")");

            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (9, 1, \"\", \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (9, 2, \"\", \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (9, 3, \"\", \"\", \"\", \"\")");

            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (10, 1, \"\", \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (10, 2, \"\", \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (10, 3, \"\", \"\", \"\", \"\")");

            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (12, 1, \"\", \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (12, 2, \"\", \"\", \"\", \"\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (12, 3, \"\", \"\", \"\", \"\")");
        }
    };
}

