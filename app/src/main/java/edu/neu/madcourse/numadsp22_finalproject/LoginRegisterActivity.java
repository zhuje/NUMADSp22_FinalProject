package edu.neu.madcourse.numadsp22_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class LoginRegisterActivity extends AppCompatActivity {

    NoLoginDialog noLoginDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up);

        noLoginDialog = new NoLoginDialog(this);



    }

    public void onClickRegister(View view){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    public void onClickNoLogin(View view){
        Intent intent = new Intent(this, TestActivity.class);

        noLoginDialog.startLoadingDialog();

        // delay loading screen dismissal
        Handler dialogHandler = new Handler();
        dialogHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                noLoginDialog.dismissDialog();
            }
        }, 2000);


//        startActivity(intent);
    }



}