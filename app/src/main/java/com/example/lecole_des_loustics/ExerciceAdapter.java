package com.example.lecole_des_loustics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.example.lecole_des_loustics.db.Exercice;

import java.util.List;

public class ExerciceAdapter extends ArrayAdapter<Exercice> {

    public ExerciceAdapter(Context mCtx, List<Exercice> exerciceList) {
        super(mCtx, R.layout.template_exercice, exerciceList);
    }

    /**
     * Remplit une ligne de la listView avec l'exercice associé
     *
     * @param id
     * @param convertView
     * @param parent
     * @return
     */

    @Override
    public View getView(int id, View convertView, ViewGroup parent) {

        // Récupération de l'exercice
        final Exercice exercice = getItem(id);

        // Charge le template XML
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.template_exercice, parent, false);

        // Récupération des objets graphiques dnas le template
        Button button = (Button) rowView.findViewById(R.id.templateExercice);
        button.setText(exercice.getExerciceName());

        return rowView;
    }
}

