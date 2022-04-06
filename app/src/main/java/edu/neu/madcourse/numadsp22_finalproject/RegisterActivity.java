package edu.neu.madcourse.numadsp22_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

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

                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                        Log.d("Cherry", user.getUid());

//                        if (user != null ) {
//                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
//                                    .setDisplayName(username).build();
//                            user.updateProfile(profileUpdates)
//                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                        @Override
//                                        public void onComplete(@NonNull Task<Void> task) {
//                                            Log.d("PRUNE", "User profile updated.");
//                                        }
//                                    });
//                        }


//                        // add user to realtime database
                        User newUser = new User(user.getUid(), username, password, email);
                        databaseReference.child("Users").child(user.getUid()).setValue(newUser)
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