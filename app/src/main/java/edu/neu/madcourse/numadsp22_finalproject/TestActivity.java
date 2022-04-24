package edu.neu.madcourse.numadsp22_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void onClickGoToProfile(View view){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void onClickGoToLesson(View view){
        Log.d("Tag", "Test 1");
        Intent intent = new Intent(this, MainLessonsScreen.class);
        startActivity(intent);
    }

    public void onClickGoToMessage(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}