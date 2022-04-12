package edu.neu.madcourse.numadsp22_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

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
     * onClickLogin -- uses firebase authentication sign users in with
     * a email and password.
     *
     * @param view current view
     */
    public void onClickLogin(View view) {
        boolean emailValid = Util.isInputValid(editTextEmail, EMAIL);
        boolean passwordValid = Util.isInputValid(editTextPassword, PASSWORD);
        if (!emailValid || !passwordValid) {
            return;
        }

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        fAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Logged in Successfully.", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), TestActivity.class));
                    } else {
                        Toast.makeText(LoginActivity.this, "Error!" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
    }


    /**
     * onClickGoToRegisterActivity -- navigates to Register Activity
     *
     * @param view current view
     */
    public void onClickGoToRegisterActivity(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }


}