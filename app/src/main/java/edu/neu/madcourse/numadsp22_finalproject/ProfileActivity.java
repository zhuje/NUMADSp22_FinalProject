package edu.neu.madcourse.numadsp22_finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {

    FirebaseUser authUserProfile;
    EditText et_pwd, et_email;
    TextView tv_username;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        authUserProfile = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        et_pwd = findViewById(R.id.et_profile_password);
        et_email = findViewById(R.id.et_profile_email);
        tv_username = findViewById(R.id.tv_profile_username);

        tv_username.setText(authUserProfile.getDisplayName());
        et_email.setHint(authUserProfile.getEmail());
    }


    public void onClickUpdatePassword(View view) {
        //Log.d("CheesyBean", et_pwd.getText().toString().trim());

        if (Util.isInputValid(et_pwd, Util.PASSWORD)) {
            authUserProfile.updatePassword(et_pwd.getText().toString().trim())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(ProfileActivity.this, "Password Successfully Updated", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ProfileActivity.this, "Password Failed to Update. Try Again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    public void onClickUpdateEmail(View view) {
        if (Util.isInputValid(et_email, Util.EMAIL)) {
            authUserProfile.updateEmail(et_email.getText().toString().trim())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                // TOOD UPDATE REALTIME DATABASE

                                Toast.makeText(ProfileActivity.this, "Email Successfully Updated", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ProfileActivity.this, "Error! " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    public void onClickLogOut(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }






}