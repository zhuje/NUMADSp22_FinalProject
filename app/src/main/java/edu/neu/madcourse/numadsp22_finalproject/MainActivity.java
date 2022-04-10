package edu.neu.madcourse.numadsp22_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.verbButton:
                startActivity(new Intent(MainActivity.this, Verb_List.class));
                break;
            case R.id.btn_demo_login:
                Intent intent = new Intent(this, LoginRegisterActivity.class);
                startActivity(intent);
                break;
        }

    }

    public void onClickProfile(View view){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

}