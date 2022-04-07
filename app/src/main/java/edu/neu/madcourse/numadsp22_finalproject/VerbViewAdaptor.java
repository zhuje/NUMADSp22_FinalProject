package edu.neu.madcourse.numadsp22_finalproject;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
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
        return view;
    }
}
