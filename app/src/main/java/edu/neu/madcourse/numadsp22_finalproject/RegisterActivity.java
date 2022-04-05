package edu.neu.madcourse.numadsp22_finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
            editTextPassword = findViewById(R.id.et_password);
        } catch (Error error){
            Log.d("RegisterActivity", "Error while finding view for edit texts :" + error);
        } catch (Exception exception) {
            Log.d("RegisterActivity", "Exception thrown while finding view for edit texts :" + exception);
        }
    }

    public void getToast(String toastMessage) {
        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();
    }

    public void onClickGoToLoginActivity(View view){
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

    /**
     * Helper function to onClickRegister.
     * Checks if each editText is NOT empty.
     * This is required to register a user.
     * @param editText the editText on the Register UI
     * @param dataType the dataType being entered (e.g. username, password, email)
     */
    public boolean isInputValid(EditText editText, String dataType){
        String string = editText.getText().toString().trim();

        Log.d("Pizza", "Inside isInputValid(), string is : " + string );

        if (dataType.equals(EMAIL)  && !Patterns.EMAIL_ADDRESS.matcher(string).matches()) {
            editText.setError("Please provide a valid email address.");
            editText.requestFocus();
            return false;
        } else if (string.isEmpty()){
            editText.setError(dataType + " is required!");
            editText.requestFocus();
            return false;
        } else {
            return true;
        }
    }



    public void onClickRegister(View view){
        // validate data input
        boolean emailValid = isInputValid(editTextEmail, EMAIL);
        boolean usernameValid = isInputValid(editTextUsername, USERNAME);
        boolean passwordValid = isInputValid(editTextPassword, PASSWORD);
        if (!emailValid || !usernameValid || !passwordValid) {
            return;
        }

        // if data valid proceed to authentication
        String email = editTextEmail.getText().toString().trim();
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

            // authenticate user
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                // add user to realtime database
                                User newUser = new User(username,password,email);
                                databaseReference.child("Users").child(username).setValue(newUser)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){
                                            // Proceed to next activity after sign-in
                                            Toast.makeText(RegisterActivity.this, "User Created.", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(getApplicationContext(), TestActivity.class));
                                        } else {
                                            Toast.makeText(RegisterActivity.this, "Error!! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } else {
                                Toast.makeText(RegisterActivity.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
    }



}