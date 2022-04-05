package edu.neu.madcourse.numadsp22_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    DialogWarningLogin noLoginDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up);

        noLoginDialog = new DialogWarningLogin(this);
    }

    public void onClickRegisterActivity(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }





}