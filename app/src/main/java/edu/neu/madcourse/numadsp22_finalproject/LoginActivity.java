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

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    public static final String EMAIL = "Email";
    public static final String PASSWORD = "Password";
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.et_login_email);
        editTextPassword = findViewById(R.id.et_login_password);
        fAuth = FirebaseAuth.getInstance();

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

    public void onClickLogin(View view){
        boolean emailValid = isInputValid(editTextEmail, EMAIL);
        boolean passwordValid = isInputValid(editTextPassword, PASSWORD);
        if (!emailValid || !passwordValid) {
            return;
        }

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        fAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Logged in Successfully.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), TestActivity.class));
                        } else {
                            Toast.makeText(LoginActivity.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

    public void onClickGoToRegisterActivity(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }






}