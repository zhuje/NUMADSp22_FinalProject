package edu.neu.madcourse.numadsp22_finalproject;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;


import java.io.IOException;
import java.util.ArrayList;

// This class helps show the Verb's CardView within its list.
public class VerbViewAdaptor extends BaseAdapter {
    private ArrayList<Verb> verbList;
    private LayoutInflater layout;
    private Context applicationContext;

    // constructor for adaptor
    public VerbViewAdaptor(ArrayList<Verb> array, Context applicationContext){
        this.verbList = array;
        this.layout = LayoutInflater.from(applicationContext);
        this.applicationContext = applicationContext;
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
        Button audioButton = view.findViewById(R.id.audioButton);
        // set it to play audio
        audioButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // make a thread to start the audio
                Runnable audioRunnable = new Runnable() {
                    @Override
                    public void run() {
                        Log.d("Tag", "thread part 1");
                        try {
                            String audioURL = verbList.get(i).getAudioURL();
                            Log.d("Tag", "thread part 2");
                            // using android studio developers documentation on mediaPlayer
                            // for the below code snippet regarding streaming via HTTP
                            Log.d("Tag", "thread part 3");
                            MediaPlayer audioPlayer = new MediaPlayer();
                            Log.d("Tag", "thread part 4");
                            audioPlayer.setAudioAttributes(
                                new AudioAttributes.Builder()
                                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                .setUsage(AudioAttributes.USAGE_MEDIA)
                                .build()
                            );
                            Log.d("Tag", "thread part 5");
                            audioPlayer.setDataSource(audioURL);
                            Log.d("Tag", "thread part 6");
                            audioPlayer.prepare();
                            Log.d("Tag", "thread part 7");
                            audioPlayer.start();
                            Log.d("Tag", "thread part 8");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };
                // now make thread and run it!
                Thread audioThread = new Thread(audioRunnable);
                // run it
                audioThread.start();
            }
        });
        // now code to open activity for recording audio!
        Button tryRecordingButton = view.findViewById(R.id.recordAudioButton);
        // set it to open a new activity
        tryRecordingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // make new intent to start recording activity
                Intent intent = new Intent(applicationContext, RecordingActivity.class);
                Bundle extraContent = new Bundle();
                // add in any extras needed: first is url of string
                extraContent.putString("urlString", verbList.get(i).getAudioURL());
                // second is picture
                extraContent.putString("picture", "" + verbList.get(i).getCharacterPicture());
                // third is word and for this we concatenate
                String wordInfo = "" + verbList.get(i).getVerbKanji() + " / "
                        + verbList.get(i).getVerbRoman();
                // add in information
                extraContent.putString("wordInfo", wordInfo);
                // add in title
                extraContent.putString("wordFile", verbList.get(i).getVerbRoman() + ".3gp");
                // put the extras in
                intent.putExtras(extraContent);
                // start activity
                applicationContext.startActivity(intent);
            }
        });
        return view;
    }
}
