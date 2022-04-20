package edu.neu.madcourse.numadsp22_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    FirebaseUser authUserProfile;
    private FirebaseAuth mAuth;
    private EditText editTextEmail, editTextUsername, editTextPassword;
    public static final String EMAIL = "Email";
    public static final String USERNAME = "Username";
    public static final String PASSWORD = "Password";
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        try {
            editTextEmail = findViewById(R.id.et_email);
            editTextUsername = findViewById(R.id.et_username);
            editTextPassword = findViewById(R.id.et_login_password);
        } catch (Error error) {
            Log.d("RegisterActivity", "Error while finding view for edit texts :" + error);
        } catch (Exception exception) {
            Log.d("RegisterActivity", "Exception thrown while finding view for edit texts :" + exception);
        }
    }


    /**
     * onClickRegister -- when the register button is clicked, this function
     * is called. Data input in each editText is checked before the User is
     * authenticated and added to the realtime database.
     *
     * @param view current view for Register Activity
     */
    public void onClickRegister(View view) {
        // validate data input
        boolean emailValid = Util.isInputValid(editTextEmail, EMAIL);
        boolean usernameValid = Util.isInputValid(editTextUsername, USERNAME);
        boolean passwordValid = Util.isInputValid(editTextPassword, PASSWORD);
        if (!emailValid || !usernameValid || !passwordValid) {
            return;
        }

        // if data valid proceed to authentication
        String email = editTextEmail.getText().toString().trim();
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // authenticate user
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        authUserProfile = FirebaseAuth.getInstance().getCurrentUser();

                        if (authUserProfile != null ) {

                            // Add User Display Name to Auth User Profile
                            Log.d("Cherry", authUserProfile.getUid());
                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(username).build();
                            authUserProfile.updateProfile(profileUpdates)
                                    .addOnCompleteListener(task12 -> Log.d("PRUNE", "User profile updated."));

                            // add user to realtime database
                            User newUser = new User(authUserProfile.getUid());
                            String userid = authUserProfile.getUid();
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("id", userid);
                            hashMap.put("username", username);
                            hashMap.put("imageURL", "default");
                            hashMap.put("status", "offline");

                            databaseReference.child("Users").child(authUserProfile.getUid()).setValue(hashMap)
                                    .addOnCompleteListener(task1 -> {
                                        if (task1.isSuccessful()) {
                                            // Proceed to next activity after sign-in
                                            Toast.makeText(RegisterActivity.this, "User Created.", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(getApplicationContext(), TestActivity.class));
                                        } else {
                                            Toast.makeText(RegisterActivity.this, "Error!! " + Objects.requireNonNull(task1.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        } else {
                            Toast.makeText(RegisterActivity.this, "Error! Occurred while trying to add user to database." , Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "Error! " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


    /**
     * onClickGoToLoginActivity -- navigates back to the LoginActivity
     *
     * @param view current View
     */
    public void onClickGoToLoginActivity(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }


}