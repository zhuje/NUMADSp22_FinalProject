package edu.neu.madcourse.numadsp22_finalproject;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.os.Bundle;

// This activity allows the user to try recording their voice to see how it compares to
// the given audio recording of the Japanese word
public class RecordingActivity extends AppCompatActivity {

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
                            // permission granted for both things
                        } else {
                            // need to explain feature is unavailable due to no permission
                            showDenyReason();
                        }
                    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording);
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