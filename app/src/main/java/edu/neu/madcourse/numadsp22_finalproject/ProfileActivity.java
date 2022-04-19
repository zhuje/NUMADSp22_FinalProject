package edu.neu.madcourse.numadsp22_finalproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    CircleImageView image_profile;
    FirebaseUser authUserProfile;
    EditText et_pwd, et_email;
    TextView tv_username, tv_profile_rank;
    DatabaseReference databaseReference;
    StorageReference storageReference;
    private static final int IMAGE_REQUEST = 1;
    private Uri imageUri;
    private StorageTask<UploadTask.TaskSnapshot> uploadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        authUserProfile = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        et_pwd = findViewById(R.id.et_profile_password);
        et_email = findViewById(R.id.et_profile_email);
        tv_username = findViewById(R.id.tv_profile_username);
        tv_profile_rank = findViewById(R.id.tv_profile_rank);
        image_profile = findViewById(R.id.profile_image);

        getUserRank();

        tv_username.setText(authUserProfile.getDisplayName());
        et_email.setHint(authUserProfile.getEmail());

        storageReference = FirebaseStorage.getInstance().getReference("uploads");



    }




    public void getUserRank(){
        databaseReference.child("Users").child(authUserProfile.getUid())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        User user = snapshot.getValue(User.class);
                        if (user != null) {
                            String myRank = String.valueOf(user.getRank());
                            // Log.d("inside getUserRank", myRank + " " + myRank.getClass());
                            tv_profile_rank.setText(myRank);
                        } else {
                            Toast.makeText(ProfileActivity.this, "Couldn't fetch user Rank.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(ProfileActivity.this, "Couldn't fetch user Rank.", Toast.LENGTH_SHORT).show();

                    }
                });
    }


    public void onClickUpdatePassword(View view) {
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