package edu.neu.madcourse.numadsp22_finalproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

// This class helps show the Verb's CardView within its list.
public class VerbViewAdaptor extends BaseAdapter {
    private ArrayList<Verb> verbList;
    private LayoutInflater layout;

    // constructor for adaptor
    public VerbViewAdaptor(ArrayList<Verb> array, Context applicationContext){
        this.verbList = array;
        this.layout = LayoutInflater.from(applicationContext);
    }

    @Override
    public int getCount() {
        return verbList.size();
    }

    @Override
    public Object getItem(int i) {
        return verbList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // inflate the card layout
        Log.d("Tag", "inside Part 1");
        view = layout.inflate(R.layout.verb_card, null);
        // fill in the verb parts
        Log.d("Tag", "inside Part 1");
        TextView verbKanji = view.findViewById(R.id.kanjiWord);
        TextView verbKana = view.findViewById(R.id.kanaWord);
        TextView verbTranslation = view.findViewById(R.id.verbTranslation);
        TextView verbRoman = view.findViewById(R.id.romanWord);
        ImageView character = view.findViewById(R.id.verbPicture);
        // fill in text
        Log.d("Tag", "inside Part 2");
        verbKanji.setText(verbList.get(i).getVerbKanji());
        verbKana.setText(verbList.get(i).getVerbKana());
        verbTranslation.setText(verbList.get(i).getVerbTranslation());
        verbRoman.setText(verbList.get(i).getVerbRoman());
        Log.d("Tag", "inside Part 3");
        // set picture
        character.setImageResource(verbList.get(i).getCharacterPicture());
        // TO DO! SETTING BUTTON TO CORRECT CODE FOR AUDIO
        return view;
    }
}
