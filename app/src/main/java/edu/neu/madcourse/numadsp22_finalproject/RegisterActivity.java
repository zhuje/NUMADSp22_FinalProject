package edu.neu.madcourse.numadsp22_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText editTextEmail, editTextUsername, editTextPassword;
    public static final String EMAIL = "Email";
    public static final String USERNAME = "Username";
    public static final String PASSWORD = "Password";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

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

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            // TODO
        }
    }

//    /**
//     * Helper function to onClickRegister.
//     * Takes a editText value from the user and converts it to string
//     * @param et input value from user set in UI's editText
//     * @return editText value converted to a string
//     */
//    public String editTextToString(EditText et){
//        return et.getText().toString().trim();
//    }

    /**
     * Helper function to onClickRegister.
     * Checks if each editText is NOT empty.
     * This is required to register a user.
     * @param editText the editText on the Register UI
     * @param dataType the dataType being entered (e.g. username, password, email)
     */
    public void checkInput(EditText editText, String dataType){
        String string = editText.getText().toString().trim();

        if (string.equals(EMAIL) && !Patterns.EMAIL_ADDRESS.matcher(string).matches()) {
            editText.setError("Please provide a valid email address.");
            editText.requestFocus();
            return;
        } else if (string.isEmpty()){
            editText.setError(dataType + " is required!");
            editText.requestFocus();
            return;
        }
    }

    public void onClickRegister(View view){
        checkInput(editTextEmail, EMAIL);
        checkInput(editTextUsername, USERNAME);
        checkInput(editTextPassword, PASSWORD);
    }



}