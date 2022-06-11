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
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"french\", \"Orthographe\", \"pick\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"french\", \"Grammaire\", \"pick\")");

            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"history\", \"Antiquité\", \"pick\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"history\", \"Moyen-Âge\", \"pick\")");

            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"geography\", \"Régions\", \"pick\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"geography\", \"Pays\", \"fillIn\")");
            db.execSQL("INSERT INTO exercice (subject, exerciceName, type) VALUES(\"geography\", \"Capitales\", \"pick\")");


            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(5, 1, \"Manger - passé composé - 1ère personne du singulier\", \"J'ai mangé\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(5, 2, \"Aller - présent - 2ème personne du pluriel\", \"Vous allez\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(5, 3, \"Fermer - futur - 3ème personne du singulier\", \"Il fermera\")");

            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(11, 1, \"De quel pays s'agit-il ?\", \"France\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(11, 2, \"De quel pays s'agit-il ?\", \"Italie\")");
            db.execSQL("INSERT INTO qfillin (exercice, numQuestion, statement, answer) VALUES(11, 3, \"De quel pays s'agit-il ?\", \"Pologne\")");

            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (6, 1, \"Quelle est la bonne orthographe ?\", \"Règle\", \"Raigle\", \"Régle\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (6, 2, \"Quelle est la bonne orthographe ?\", \"Eléphant\", \"Elefant\", \"Eléphent\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (6, 3, \"Quelle est la bonne orthographe ?\", \"Grammaire\", \"Gramaire\", \"Grammeire\")");

            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (7, 1, \"Quelle est la fontion de 'son terrier' dans 'Le lapin est sorti de son terrier' ?\", \"COI\", \"COD\", \"Sujet\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (7, 2, \"Quelle est la fontion de 'sa voiture' dans 'Marie conduit sa voiture' ?\", \"COD\", \"COI\", \"Sujet\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (7, 3, \"Quelle est la fontion de 'Lucas' dans 'Lucas joue au tennis' ?\", \"Sujet\", \"COI\", \"COD\")");

            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (8, 1, \"Quel général romain a conquis la Gaule ?\", \"Jules César\", \"Scipion l'Africain\", \"Pompée\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (8, 2, \"Chez quelle culture trouvait-on des druides ?\", \"Gaulois\", \"Han\", \"Grecs\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (8, 3, \"Lequel de ces dieux les romains ne vénéraient-ils pas ?\", \"Cernunnos\", \"Jupiter\", \"Mars\")");

            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (9, 1, \"De qui Clovis était-il le rois ?\", \"Les Francs\", \"Les Français\", \"Les Goths\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (9, 2, \"Quel élément défensif encercle les châteaux-forts ?\", \"Les douves\", \"Les meurtrières\", \"Le donjon\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (9, 3, \"Au cours de quelle cérémonie le titre de chevalier est-il conféré ?\", \"L'adoubement\", \"La messe\", \"Les moissons\")");

            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (10, 1, \"Quelle région se trouve au sud de la Bourgogne-Franche-Comté?\", \"Auvergne-Rhône-Alpes\", \"Centre-Val de Loire\", \"Grand Est\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (10, 2, \"Quelle région borde à la fois l'Océan Atlantique et l'Espagne ?\", \"Nouvelle-Aquitaine\", \"Hauts-de-France\", \"Corse\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (10, 3, \"De quelle région sont originaires les calissons ?\", \"Provence-Alpes-Côte d'Azur\", \"Île-de-France\", \"Bretagne\")");

            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (12, 1, \"Quelle est la capitale de Chypre ?\", \"Nicosie\", \"Rome\", \"Londres\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (12, 2, \"Quelle est la capitale de l'Allemagne ?\", \"Berlin\", \"Dublin\", \"Lisbonne\")");
            db.execSQL("INSERT INTO qpick (exercice, numQuestion, statement, rightAnswer, wrongAnswer1, wrongAnswer2) VALUES (12, 3, \"Quelle est la capitale de l'Estonie ?\", \"Tallinn\", \"Belgrade\", \"Varsovie\")");
        }
    };
}

