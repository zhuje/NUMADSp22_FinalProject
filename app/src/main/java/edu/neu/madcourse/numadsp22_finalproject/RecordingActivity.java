package edu.neu.madcourse.numadsp22_finalproject;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

// This activity allows the user to try recording their voice to see how it compares to
// the given audio recording of the Japanese word
public class RecordingActivity extends AppCompatActivity {

    private int characterPicture;
    private String audioURL;
    private String wordInfo;
    private Button nativeAudioButton;


    /**
     * this is for requesting permissions from user
     */
    public ActivityResultLauncher<String[]> audioPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(),
                    isGranted -> {
                        // check audio recording permission
                        Boolean audioRecording
                                = isGranted.getOrDefault(Manifest.permission.RECORD_AUDIO,
                                false);
                        // check coarse location permission
                        Boolean writeStorage
                                = isGranted.getOrDefault(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                false);
                        if ((audioRecording != null && audioRecording) && (writeStorage
                                != null && writeStorage)) {
                            // permission granted for both things, can go ahead
                        } else {
                            // need to explain feature is unavailable due to no permission
                            showDenyReason();
                        }
                    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording);
        // get information from intent
        getWordInformation();
        // now fill that into page
        TextView wordText = findViewById(R.id.audio_text_word);
        wordText.setText(wordInfo);
        ImageView character = findViewById(R.id.audio_picture);
        character.setImageResource(characterPicture);
        // button for playing audio from native speaker
        nativeAudioButton = findViewById(R.id.listenButton);
        nativeAudioButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                // play audio from native speaker
                // make a thread to start the audio
                Runnable audioRunnable = new Runnable() {
                    @Override
                    public void run() {
                        Log.d("Tag", "thread part 1");
                        try {
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
    }

    /**
     * This is for getting the information passed alongside the intent
     */
    private void getWordInformation() {
        Intent intent = getIntent();
        // check that it is not null
        if (intent != null) {
            characterPicture = Integer.parseInt(intent.getStringExtra("picture"));
            audioURL = intent.getStringExtra("urlString");
            wordInfo = intent.getStringExtra("wordInfo");
        } else {
            // alert that intent is null
            Toast.makeText(this, "Intent is null", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * this is for showing the rational behind requesting permission for audio recording
     */
    private void showAudioReason(){
        // make alert dialog
        AlertDialog.Builder giveReason = new AlertDialog.Builder(RecordingActivity.this);
        // give reason permission is needed for this app
        giveReason.setTitle("Audio recording permission is required in order to user this feature.");
        // now give button for user to acknowledge
        giveReason.setPositiveButton("Set Permissions",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // request permission again once reason is shown
                        audioPermissionLauncher.launch(new String[]
                                {Manifest.permission.RECORD_AUDIO,
                                        Manifest.permission.WRITE_EXTERNAL_STORAGE});
                    }
                });
        giveReason.show();
    }

    /**
     * This will show user reason why ability to play this was denied
     */
    public void showDenyReason() {
        // make alert dialog
        AlertDialog.Builder giveReason = new AlertDialog.Builder(RecordingActivity.this);
        // give reason for denying
        giveReason.setTitle(R.string.deny_reason);
        // now give button for user to acknowledge
        giveReason.setPositiveButton(R.string.okay_option, null);
        giveReason.show();
    }
}