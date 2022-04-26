package edu.neu.madcourse.numadsp22_finalproject;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

// This activity allows the user to try recording their voice to see how it compares to
// the given audio recording of the Japanese word
public class RecordingActivity extends AppCompatActivity {

    private int characterPicture;
    private String audioURL;
    private String wordInfo;
    private String wordFile;
    private String fileToSave;
    private boolean recordingOn;
    private MediaRecorder audioRecorder;

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
                        // check read external storage permission
                        Boolean readStorage
                                = isGranted.getOrDefault(Manifest.permission.READ_EXTERNAL_STORAGE,
                                false);
                        // check write external storage permission
                        Boolean writeStorage
                                = isGranted.getOrDefault(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                false);
                        if ((audioRecording != null && audioRecording) && (writeStorage
                                != null && writeStorage) && (readStorage != null && readStorage)) {
                            // permission granted for all things, can go ahead
                        } else {
                            // need to explain feature is unavailable due to no permission
                            showDenyReason();
                        }
                    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording);
        recordingOn = false;
        //TODO - make certain that information works still with orientation change

        // get information from intent
        getWordInformation();
        // now fill that into page
        TextView wordText = findViewById(R.id.audio_text_word);
        wordText.setText(wordInfo);
        ImageView character = findViewById(R.id.audio_picture);
        character.setImageResource(characterPicture);
        // button for playing audio from native speaker
        Button nativeAudioButton = findViewById(R.id.listenButton);
        nativeAudioButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // play audio from native speaker
                if (!recordingOn) {
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
            }
        });
        // this button will address starting the recording
        Button recordingButton = findViewById(R.id.recordingButton);
        recordingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check that there is a mic on the system
                if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE)) {
                    // we can record
                    // need to check for permissions for recording already being available
                    if (ContextCompat.checkSelfPermission(RecordingActivity.this,
                            Manifest.permission.RECORD_AUDIO )
                            == PackageManager.PERMISSION_GRANTED &&
                            ContextCompat.checkSelfPermission(RecordingActivity.this,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE)
                                    == PackageManager.PERMISSION_GRANTED
                            && ContextCompat.checkSelfPermission(RecordingActivity.this,
                            Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED) {
                        // in this case permission is granted and can record
                        // set it up - using developers documentation on MediaRecorder
                        audioRecorder = new MediaRecorder();
                        // this is the file we will save it as
                        fileToSave = getExternalCacheDir().getAbsolutePath() + "/" + wordFile;
                        // set source as mic
                        audioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                        audioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                        audioRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                        audioRecorder.setOutputFile(fileToSave);
                        // once set up we can record
                        recordAudio();
                    } else if (shouldShowRequestPermissionRationale(
                            Manifest.permission.RECORD_AUDIO)
                            || shouldShowRequestPermissionRationale(
                            Manifest.permission.WRITE_EXTERNAL_STORAGE) ||
                            shouldShowRequestPermissionRationale(
                            Manifest.permission.READ_EXTERNAL_STORAGE)) {
                        // need to tell reason why we need to request permission
                        // this is if user has denied permission before
                        showAudioReason();
                    } else {
                        // need to ask for permission to record if this is first time
                        audioPermissionLauncher.launch(new String[]
                                {Manifest.permission.RECORD_AUDIO,
                                        Manifest.permission.READ_EXTERNAL_STORAGE,
                                        Manifest.permission.WRITE_EXTERNAL_STORAGE});
                    }
                } else {
                    // make alert dialog
                    AlertDialog.Builder giveReason =
                            new AlertDialog.Builder(RecordingActivity.this);
                    // give reason permission is needed for this app
                    giveReason.setTitle("No microphone is available to use this feature.");
                    // now give button for user to acknowledge
                    giveReason.setPositiveButton(R.string.okay_option, null);
                    giveReason.show();
                }
            }
        });
        // this button will address stopping the recording
        Button stopButton = findViewById(R.id.pauseButton);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // this will stop the recording
                stopRecording();
            }
        });
        // This button will replay the file
        Button playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check that file exists
                if (fileToSave != null && new File(fileToSave).exists()) {
                    // now run file
                    if (!recordingOn) {
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
                                    // in this case we want fileToSave to be source
                                    audioPlayer.setDataSource(fileToSave);
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
                }
            }
        });
    }

    /**
     * This class is used for recording audio
     */
    private void recordAudio() {
        if (!recordingOn){
            // set it to true that it is running
            recordingOn = true;
            // try/catch for IOException for running recording
            try {
                audioRecorder.prepare();
                audioRecorder.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This class is for stopping the recording
     */
    private void stopRecording(){
        // will do nothing unless recording is on
        if (recordingOn){
            Log.d("tagging 1", "before stop");
            audioRecorder.stop();
            Log.d("tagging 1", "after stop");
            audioRecorder.reset();
            // change whether it is recording to false
            recordingOn = false;
        }
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
            // next will be full file name of audio file
            wordInfo = intent.getStringExtra("wordInfo");
            wordFile = intent.getStringExtra("wordFile");
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