package edu.neu.madcourse.numadsp22_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class Verb_List extends AppCompatActivity {

    private ArrayList<Verb> verbList = new ArrayList<>();
    private ListView viewList;
    private VerbViewAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verb_list);
        // fill in list with a new verb
        int suwaruPicture = R.drawable.suwaru;
        Verb suwaru = new Verb("座る", "すわる", "suwaru",
                "to sit", suwaruPicture,
                "https://d1vjc5dkcd3yh2.cloudfront.net/audio/6ab09ed3495fb3563b270b11845a1443.mp3");
        // add to list
        suwaru.getVerbKana();
        Log.d("Tag", "Part 1");
        verbList.add(suwaru);
        Log.d("Tag", "Part 2");
        viewList = findViewById(R.id.verbList);
        Log.d("Tag", "Part 3");
        // make adaptor
        adaptor = new VerbViewAdaptor(verbList, Verb_List.this);
        Log.d("Tag", "Part 4");
        viewList.setAdapter(adaptor);
        Log.d("Tag", "Part 5");
    }
}